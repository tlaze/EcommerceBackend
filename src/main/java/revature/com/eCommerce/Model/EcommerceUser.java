package revature.com.eCommerce.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class EcommerceUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
    private String password;

}
