package revature.com.eCommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import revature.com.eCommerce.Model.EcommerceProduct;
import revature.com.eCommerce.Service.ProductInterface;

@SpringBootApplication
public class ECommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmd (ProductInterface productInterface){
		return args ->{
			EcommerceProduct p = new EcommerceProduct(1,"shirt", "red", 10);
			productInterface.save(p);
			p = new EcommerceProduct(2,"pants", "blue", 15);
			productInterface.save(p);

		};
	}

}
