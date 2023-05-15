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
			EcommerceProduct p = new EcommerceProduct(1,"shirt", "red",5, 10, "https://dummyimage.com/300x200/000/fff", user);
			productInterface.save(p);
			p = new EcommerceProduct(2,"pants", "blue", 15,5, "https://dummyimage.com/300x200/000/fff",user);
			productInterface.save(p);
			p = new EcommerceProduct(3,"pants", "blue", 15,5, "https://dummyimage.com/300x200/000/fff",user);
			productInterface.save(p);
			p = new EcommerceProduct(4,"pants", "blue", 15,5, "https://dummyimage.com/300x200/000/fff",user);
			productInterface.save(p);
			p = new EcommerceProduct(5,"pants", "blue", 15,5, "https://dummyimage.com/300x200/000/fff",user);
			productInterface.save(p);
			p = new EcommerceProduct(6,"pants", "blue", 15,5, "https://dummyimage.com/300x200/000/fff",user);
			productInterface.save(p);
			p = new EcommerceProduct(7,"pants", "blue", 15,5, "https://dummyimage.com/300x200/000/fff",user);
			productInterface.save(p);
			p = new EcommerceProduct(8,"pants", "blue", 15,5, "https://dummyimage.com/300x200/000/fff",user);
			productInterface.save(p);
			p = new EcommerceProduct(9,"pants", "blue", 15,5, "https://dummyimage.com/300x200/000/fff",user);
			productInterface.save(p);
		};
	}

}
