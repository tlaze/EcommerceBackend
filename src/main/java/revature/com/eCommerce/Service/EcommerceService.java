package revature.com.eCommerce.Service;

import org.springframework.stereotype.Service;
import revature.com.eCommerce.Model.EcommerceUser;

@Service
public class EcommerceService {

    public EcommerceUser signup(EcommerceUser user){
        return EcommerceInterface.save(user);
    }
}
