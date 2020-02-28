package SmartShop.Spring_Boot_SmartShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.smartshop.configuration")
public class SpringBootSmartShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSmartShopApplication.class, args);
	}

}
