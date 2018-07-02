package cn.cnnic.springcloudclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudClient2Application.class, args);
	}
}
