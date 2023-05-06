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
public class EcommerceController {

    @Autowired
    EcommerceService userService;
    EcommerceService productService;

    public EcommerceController(EcommerceService userService, EcommerceService productService){
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("signup")
    public ResponseEntity signup(@RequestBody EcommerceUser user){
        userService.signup(user);
        return ResponseEntity.ok("User Successfully Added");
    }

    @GetMapping
    public List<EcommerceUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody EcommerceUser user){
        try{
            userService.login(user);
            return ResponseEntity.ok("User Successfully Logged In");
        }
        catch(UserNotFoundException e){
            return ResponseEntity.ok("User is not registered");
        }
    }

    @GetMapping("home")
    public List<EcommerceProduct> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("cart/{productId}")
    public ResponseEntity addToCart(@PathVariable long productId, @RequestBody EcommerceProduct product){
        productService.addToCart(productId, product);
        return ResponseEntity.ok("Item added to cart");
    }

    @PatchMapping("cart/{id}")
    public ResponseEntity checkout(@PathVariable long id){
        productService.checkout(id);
        return ResponseEntity.ok("Your Order Is Completed.");
    }





}
