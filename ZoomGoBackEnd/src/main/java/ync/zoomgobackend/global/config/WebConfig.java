package ync.zoomgobackend.global.config;
<<<<<<< HEAD

=======
>>>>>>> main
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
<<<<<<< HEAD
=======

>>>>>>> main
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${upload.path}") // 외부 설정 파일에서 파일 저장 경로 주입
    private String uploadDir;

    @Override
<<<<<<< HEAD
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 엔드포인트에 대해 CORS 설정
                .allowedOrigins("http://localhost:3000") // React 앱에서 오는 요청을 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메소드
                .allowedHeaders("*"); // 모든 헤더 허용
    }

    @Override
=======
>>>>>>> main
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /files/** 경로를 로컬 디렉토리로 매핑
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:" + uploadDir); // 로컬 디렉토리 매핑
    }
<<<<<<< HEAD
=======

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해
                .allowedOrigins("http://localhost:3000") // 허용할 출처
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
                .allowedHeaders("*") // 허용할 헤더
                .allowCredentials(true); // 자격 증명 허용
    }
>>>>>>> main
}
