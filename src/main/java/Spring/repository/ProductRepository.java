package Spring.repository;

import Spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product save(Product product);

    // <------------  get methods for Product --------------->
    @Query("FROM Product")
    List<Product> findAll();

    @Query("FROM Product where name =:name")
    Product getProductByName(String name);

    @Query("FROM Product where productId =:id")
    Product getProductById(int id);

    @Query("FROM Product where name =:name")
    Product putProductByName(String name);


    //<------------ Delete Method ------------------->

    void delete(Product product);




}
