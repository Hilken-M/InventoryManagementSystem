package Spring.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @Column
    private String name; //make this column unique
    @Column
    private float price;

    @OneToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
    @JoinColumn(name="productId")
    private Collection<Inventory> inventoryId = new ArrayList<>();

}
