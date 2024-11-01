package kr.ac.ync.zoomgo.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing//jpa 변화감지

public class ZoomGoBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZoomGoBackEndApplication.class, args);
	}

}
