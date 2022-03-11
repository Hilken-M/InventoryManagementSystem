package Spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventoryId", updatable = false, nullable = false)
    private int inventoryId;
    @Column
    private int quantity;



    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name="productId")
    private Product product;
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name="storeId")
    private Store store;
}
