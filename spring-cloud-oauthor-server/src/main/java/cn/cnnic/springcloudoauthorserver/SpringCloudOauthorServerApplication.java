package cn.cnnic.springcloudoauthorserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author jessen qiang
 *
 */
@SpringBootApplication
public class SpringCloudOauthorServerApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOauthorServerApplication.class, args);
	}
}
