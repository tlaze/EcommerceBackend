package revature.com.eCommerce.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import revature.com.eCommerce.Model.EcommerceProduct;

public interface ProductInterface extends JpaRepository<EcommerceProduct, Long> {
}
