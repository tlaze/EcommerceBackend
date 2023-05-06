package revature.com.eCommerce.Service;

import org.springframework.stereotype.Service;
import revature.com.eCommerce.Exception.UserNotFoundException;
import revature.com.eCommerce.Model.EcommerceProduct;
import revature.com.eCommerce.Model.EcommerceUser;

import java.util.ArrayList;
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

    public EcommerceProduct addToCart(long productId, EcommerceProduct product){
        EcommerceUser user = userInterface.findById(productId).get();
        user.getCart().add(product);
        product.setUser(user);
        user.setBalance((user.getBalance()) + product.getPrice());
        return productInterface.save(product);
    }

    public EcommerceUser checkout(long id){
        EcommerceUser user = userInterface.findById(id).get();
        user.getCart().clear();
        user.setBalance(0);
        return userInterface.save(user);

    }
}
