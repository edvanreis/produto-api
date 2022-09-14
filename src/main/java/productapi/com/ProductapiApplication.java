package productapi.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ProductapiApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(ProductapiApplication.class, args);
		var name = app.getEnvironment().getProperty("spring.application.name");
		var version = app.getEnvironment().getProperty("server.version");


		log.info("\n----------------------------------------------------------\n" +
						"Application '{}' is running!\n\t" +
						"Version: \t{}\n\t"+
						"----------------------------------------------------------",
				name, version);
	}

}
