package revature.com.eCommerce.Controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import revature.com.eCommerce.Exception.UserNotFoundException;
import revature.com.eCommerce.Model.EcommerceUser;
import revature.com.eCommerce.Service.EcommerceService;

import java.util.List;

@RestController
@RequestMapping
public class EcommerceController {

    @Autowired
    EcommerceService userService;

    public EcommerceController(EcommerceService userService){
        this.userService = userService;
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
            userService.login(user.getUsername(), user.getPassword());
            return ResponseEntity.ok("User Successfully Logged In");
        }
        catch(UserNotFoundException e){
            return ResponseEntity.ok("User is not registered");
        }
    }



}
