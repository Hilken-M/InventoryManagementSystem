package Spring.controller;

import Spring.model.Product;
import Spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Spring.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // <------------  get methods for Product --------------->

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }

    @RequestMapping(value = "/name/{name}", method = {RequestMethod.GET, RequestMethod.POST})
    //@GetMapping("/product/name/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @RequestMapping(value = "/product/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    //@GetMapping("/product/id/{productId}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    //<---------------- Create/update methods -------------->

    @RequestMapping(method = RequestMethod.PUT,value ="/product/{id}")
    public void updateProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    //<------------ Delete Method ------------------->

    @DeleteMapping("/deleteProduct/{product}")
    public Boolean deleteProduct(@PathVariable Product product){
        productService.deleteProduct(product);
        System.out.println(product.toString() + " was deleted from list of products");
        return true;
    }


}
