package revature.com.eCommerce.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
public class EcommerceProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private long price;

    @Column
    private long quantity;

    @Column
    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(referencedColumnName = "id")
    private EcommerceUser user;

    public EcommerceProduct(long id, String name, String description, long price, long quantity, String imageUrl, EcommerceUser user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.user = user;
    }
}
