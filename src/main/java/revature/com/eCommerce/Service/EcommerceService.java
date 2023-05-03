package revature.com.eCommerce.Service;

import org.springframework.stereotype.Service;
import revature.com.eCommerce.ECommerceApplication;
import revature.com.eCommerce.Model.EcommerceUser;

@Service
public class EcommerceService {

    EcommerceInterface ecommerceInterface;

    public EcommerceService(EcommerceInterface ecommerceInterface) {
        this.ecommerceInterface = ecommerceInterface;
    }

    public EcommerceUser signup(EcommerceUser user){
        return ecommerceInterface.save(user);
    }
}
