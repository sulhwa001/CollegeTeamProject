//package ync.zoomgobackend.global.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SercurityConfig {
//
//    @Configuration
//    @EnableWebSecurity
//    public class SecurityConfig {
//
//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화
//                    .authorizeHttpRequests(auth -> auth
//                            .anyRequest().permitAll() // 모든 요청 허용
//                    )
//                    .formLogin(AbstractHttpConfigurer::disable) // 기본 폼 로그인 비활성화
//                    .httpBasic(AbstractHttpConfigurer::disable); // 기본 HTTP Basic 인증 비활성화
//
//
//            return http.build();
//        }
//
//    }
//
//
//}