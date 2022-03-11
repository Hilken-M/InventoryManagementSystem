package Spring.service;

import Spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import Spring.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


// <------------  get methods for Product --------------->

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name) {
        return (productRepository.getProductByName(name));
    }


    public Product getProductById(int id) {
        return (productRepository.getProductById(id));
    }


    //<---------------- Create/update methods -------------->
    public Product putProductByName(String name){
        return (productRepository.putProductByName(name));
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

//    public void updateProduct(Product product){
//        productRepository.save(product);
//    }


    //<------------ Delete Method ------------------->
    public Boolean deleteProduct(int id) {
        productRepository.deleteProduct(id);
        System.out.println(id + " has been deleted from the list of products!");
        return true;
    }

//    public Boolean deleteByProductId(Product product) {
//        productRepository.deleteByProductId(product);
//        System.out.println("The product listed by Id: "+product+" has been deleted!");
//        return true;
//    }

    public Boolean deleteByProductName(String name) {
        productRepository.deleteByProductName(name);
        System.out.println("All products named:  "+name+" has been deleted!");
        return true;
    }

    public Boolean deleteByProductId(int price) {
        productRepository.deleteByProductId(price);
        System.out.println("All products that cost: "+price+" has been deleted!");
        return true;
    }
}

//    public Product createOrUpdateProduct(int productId){
////            if (product.isPresent()){
////                Product newProduct = product.get();
////                newProduct.setName(product.getName());
////            }
////
////
////        }