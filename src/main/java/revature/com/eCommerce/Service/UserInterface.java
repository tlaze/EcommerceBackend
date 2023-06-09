package revature.com.eCommerce.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import revature.com.eCommerce.Model.EcommerceUser;

@Repository
public interface UserInterface extends JpaRepository<EcommerceUser,Long> {
    EcommerceUser findByUsernameAndPassword(String username, String password);

    Object findByUsername(String username);
}

