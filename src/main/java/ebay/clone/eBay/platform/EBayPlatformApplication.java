package ebay.clone.eBay.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class EBayPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBayPlatformApplication.class, args);
	}

}
