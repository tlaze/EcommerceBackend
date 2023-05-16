package revature.com.eCommerce.Controller;

import jakarta.persistence.PreUpdate;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import revature.com.eCommerce.Exception.UserNotFoundException;
import revature.com.eCommerce.Model.EcommerceProduct;
import revature.com.eCommerce.Model.EcommerceUser;
import revature.com.eCommerce.Service.EcommerceService;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class EcommerceController {

    @Autowired
    EcommerceService userService;
    EcommerceService productService;

    public EcommerceController(EcommerceService userService, EcommerceService productService){
        this.userService = userService;
        this.productService = productService;
    }

//    Registers new accounts
    @PostMapping("registration")
    public EcommerceUser signup(@RequestBody EcommerceUser user){
        return userService.signup(user);
    }

//    Gets a list of all registered users
    @GetMapping
    public List<EcommerceUser> getAllUsers(){
        return userService.getAllUsers();
    }

//    Changes boolean of isLoggedIn whether user clicks login or log out
    @PatchMapping("registration/{id}")
    public EcommerceUser changeLoginStatus(@RequestBody EcommerceUser user, @PathVariable long id){
        return userService.changeLoginStatus(user,id);
    }

//    Gets all products for displaying on homepage
    @GetMapping("home")
    public List<EcommerceProduct> getAllProducts(){
        return productService.getAllProducts();
    }

//    Adds an item to users cart
    @PostMapping("cart/{accountID}")
    public EcommerceProduct addToCart(@PathVariable long accountID, @RequestBody EcommerceProduct product){
        return productService.addToCart(accountID, product);
    }

//    Finds items in a users cart from their user id. Used to display items on checkout page
    @GetMapping("registration/{accountID}")
    public EcommerceUser getCartByID(@PathVariable long accountID){
        return userService.getCartByID(accountID);
    }

//    Makes patch request to empty out a user's cart and set balance back to 0
    @PatchMapping("cart/{id}")
    public EcommerceUser checkout(@PathVariable long id){
        return productService.checkout(id);
    }
}
