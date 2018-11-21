package com.qbk;

import com.qbk.entity.TestInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;

import java.net.InetAddress;

@Log4j2
@SpringBootApplication
@EnableKafka
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);

		SpringApplication app = new SpringApplication(Application.class);
		Environment env = app.run(args).getEnvironment();
		String protocol = "http";
		if (env.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}
		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			log.warn("无法使用`localhost`作为访问路径");
		}
		log.info("\n----------------------------------------------------------\n\t" +
						"应用 '{}'正在运行! 访问路径为:\n\t" +
						"本地: \t\t{}://localhost:{}\n\t" +
						"外部: \t{}://{}:{}\n\t" +
						"环境: \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol,
				env.getProperty("server.port"),
				protocol,
				hostAddress,
				env.getProperty("server.port"),
				env.getActiveProfiles());
	}
}
