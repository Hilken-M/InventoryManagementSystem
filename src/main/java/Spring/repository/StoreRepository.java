package Spring.repository;

import Spring.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StoreRepository extends JpaRepository<Store, Integer> {

    Store save(Store store);

    @Query("FROM Store")
    List<Store> findall();

    @Query("FROM Store where storeID =:id")
    Store getStoreById(int id);

    @Query("FROM Store where storeId =:id")
    Boolean deleteByStoreId(int id);
}
