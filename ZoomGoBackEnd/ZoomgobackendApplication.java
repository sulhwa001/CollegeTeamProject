package ync.zoomgobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ZoomgobackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZoomgobackendApplication.class, args);
	}

}
