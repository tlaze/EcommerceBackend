package revature.com.eCommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import revature.com.eCommerce.Model.EcommerceUser;
import revature.com.eCommerce.Service.EcommerceService;

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

}
