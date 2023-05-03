package revature.com.eCommerce.Service;

import org.springframework.stereotype.Service;
import revature.com.eCommerce.Exception.UserNotFoundException;
import revature.com.eCommerce.Model.EcommerceProduct;
import revature.com.eCommerce.Model.EcommerceUser;

import java.util.List;

@Service
public class EcommerceService {

    UserInterface userInterface;
    ProductInterface productInterface;

    public EcommerceService(UserInterface userInterface, ProductInterface productInterface) {
        this.userInterface = userInterface;
        this.productInterface = productInterface;
    }

    public EcommerceUser signup(EcommerceUser user){
        return userInterface.save(user);
    }

    public List<EcommerceUser> getAllUsers(){
        return userInterface.findAll();
    }

    public EcommerceUser login(String username, String password){
        EcommerceUser userLogin = userInterface.findByUsernameAndPassword(username, password);

        if(userLogin == null){
            throw new UserNotFoundException("User is not registered");
        }
        else{
            return userLogin;
        }
    }

    public List<EcommerceProduct> getAllProducts(){
        return productInterface.findAll();
    }
}
