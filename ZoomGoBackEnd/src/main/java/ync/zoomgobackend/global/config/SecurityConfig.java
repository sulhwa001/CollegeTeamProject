package ync.zoomgobackend.global.config;




import ync.zoomgobackend.global.jwt.filter.JwtAuthenticationFilter;
import ync.zoomgobackend.global.jwt.filter.JwtExceptionFilter;
import ync.zoomgobackend.global.security.CustomUserDetailsService;
import ync.zoomgobackend.global.security.handler.JwtAccessDeniedHandler;
import ync.zoomgobackend.global.security.handler.JwtAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    private final CustomUserDetailsService customUserDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private  final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtExceptionFilter jwtExceptionFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception{
        http.
                csrf(AbstractHttpConfigurer::disable)//CSRF 비활성화
                //비활성화 하겠다 get을 제외한 모든요청에는 csrf토큰을 계속
                //넣어줘야함 그래야지 요청이 정상적으로 이루어짐
                .authenticationProvider(authenticationProvider())
                .exceptionHandling(handlingConfigurer->handlingConfigurer.
                        authenticationEntryPoint(jwtAuthenticationEntryPoint)//401
                        .accessDeniedHandler(jwtAccessDeniedHandler) //403
                )
                .authorizeHttpRequests(
                        authorize->
                                authorize.requestMatchers("/api/members/**","/auth/**","/emailCheck","/numberCheck", "/api/upload", "/api/display", "/gosu/**").permitAll().
                                        requestMatchers("/admin/**")
                                        .hasAnyRole("ADMIN")
                                        .anyRequest()
                                        .authenticated())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtExceptionFilter, JwtAuthenticationFilter.class)
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //세션을 사용하지 않음
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception
    {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider daoAuthenticationProvider=
                new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
