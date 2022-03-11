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

//    List<Product> findAllByPrice(float price);

    @Query("FROM Product where productId =:id")
    Product getProductById(int id);

//    @Query("FROM Product where price =:price")
//    Product findProductByPrice(float price);
    @Query("FROM Product where name =:name")
    Product putProductByName(String name);

//    @Query("FROM product where name =:name")
//    Product putProductByName(name);

    //<-----------Attempt 3?------------->


//    public List<Product> findAllProductByName(String name){
//        return product.stream().filter(product -> product.getName().equals(name)).collect(Collectors.toList());
//    }


    //<------------ Delete Method ------------------->
    @Query("FROM Product where productId =:id")
    void deleteProduct(int id);

    @Query("FROM Product where name =:name")
    void deleteByProductName(String name);

    @Query("FROM Product where productId =:id")
    void deleteByProductId(int id);


}
