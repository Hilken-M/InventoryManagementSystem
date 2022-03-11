package Spring.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="store")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Store {
    @Id
    private int storeId;
    @Column
    private String storeName;
    @Column
    private String stateName;
    @Column
    private String cityName;

    @OneToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
    @JoinColumn(name="storeId")
    private Collection<Inventory> inventoryId = new ArrayList<>();

}
