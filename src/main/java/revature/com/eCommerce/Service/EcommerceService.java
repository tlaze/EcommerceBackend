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

//    Saves account information when a user signs up
    public EcommerceUser signup(EcommerceUser user){
        return userInterface.save(user);
    }

//    Finds all the users in the database
    public List<EcommerceUser> getAllUsers(){
        return userInterface.findAll();
    }

//    Finds a user by their id, sets their isLoggedIn boolean status to whatever action user takes login/logout
    public EcommerceUser changeLoginStatus(EcommerceUser user, long id){
        EcommerceUser userLogin = userInterface.findById(id).get();
        userLogin.setIsLoggedIn(user.getIsLoggedIn());
        userInterface.save(userLogin);
        return userLogin;
    }

//    Finds all products in the database
    public List<EcommerceProduct> getAllProducts(){
        return productInterface.findAll();
    }

//    finds user by their id, adds the item they chose to their cart, sets their balance to the price of the item
    public EcommerceProduct addToCart(long productId, EcommerceProduct product){
        EcommerceUser user = userInterface.findById(productId).get();
        user.getCart().add(product);
        product.setUser(user);
        user.setBalance((user.getBalance()) + product.getPrice());
        return productInterface.save(product);
    }

//    find's the user's cart by their id
    public EcommerceUser getCartByID(long id){
        EcommerceUser user = userInterface.findById(id).get();
        return user;
    }

//    Finds user by their id, clears their car and sets balance to 0
    public EcommerceUser checkout(long id){
        EcommerceUser user = userInterface.findById(id).get();
        user.getCart().clear();
        user.setBalance(0);
        return userInterface.save(user);

    }
}
