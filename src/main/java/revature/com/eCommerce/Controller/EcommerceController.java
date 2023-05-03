package revature.com.eCommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

}
