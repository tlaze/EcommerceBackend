package revature.com.eCommerce.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import revature.com.eCommerce.ECommerceApplication;
import revature.com.eCommerce.Exception.EcommerceExceptionAdvice;
import revature.com.eCommerce.Exception.UserNotFoundException;
import revature.com.eCommerce.Model.EcommerceUser;

import java.util.List;

@Service
public class EcommerceService {

    EcommerceInterface ecommerceInterface;

    public EcommerceService(EcommerceInterface ecommerceInterface) {
        this.ecommerceInterface = ecommerceInterface;
    }

    public EcommerceUser signup(EcommerceUser user){
        return ecommerceInterface.save(user);
    }

    public List<EcommerceUser> getAllUsers(){
        return ecommerceInterface.findAll();
    }

    public EcommerceUser login(String username, String password){
        EcommerceUser userLogin = ecommerceInterface.findByUsernameAndPassword(username, password);

        if(userLogin == null){
            throw new UserNotFoundException("User is not registered");
        }
        else{
            return userLogin;
        }
    }
}
