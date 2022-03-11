package Spring.repository;

import Spring.model.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    Inventory save(Inventory inventory);

    @Query("FROM Store")
    List<Inventory> findall();

    @Query("FROM Store where storeID =:id")
    Inventory getInventoryById(int id);

    void delete(Inventory inventory);

}
