package Spring.service;

import Spring.Application;
import Spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import Spring.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Component
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


    //<------------ Delete Method ------------------->
    public void deleteProduct(Product product) {
        productRepository.delete(product);
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