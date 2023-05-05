package revature.com.eCommerce.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(fetch = FetchType.EAGER)
    List<EcommerceProduct> cart;

}
