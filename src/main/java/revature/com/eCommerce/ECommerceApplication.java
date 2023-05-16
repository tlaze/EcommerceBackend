package revature.com.eCommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import revature.com.eCommerce.Model.EcommerceProduct;
import revature.com.eCommerce.Model.EcommerceUser;
import revature.com.eCommerce.Service.ProductInterface;

@SpringBootApplication
public class ECommerceApplication {

	EcommerceUser user;
	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmd (ProductInterface productInterface){
		return args ->{
			EcommerceProduct p = new EcommerceProduct(1,"Sparky", 25, "http://placekitten.com/300/200", user);
			productInterface.save(p);
			p = new EcommerceProduct(2,"Meatball",25, "http://placekitten.com/300/200",user);
			productInterface.save(p);
			p = new EcommerceProduct(3,"Tiger",25, "http://placekitten.com/300/200",user);
			productInterface.save(p);
			p = new EcommerceProduct(4,"Luna",35, "http://placekitten.com/300/200",user);
			productInterface.save(p);
			p = new EcommerceProduct(5,"Oliver", 45, "http://placekitten.com/300/200",user);
			productInterface.save(p);
			p = new EcommerceProduct(6,"Otto",50, "http://placekitten.com/300/200",user);
			productInterface.save(p);

		};
	}

}
