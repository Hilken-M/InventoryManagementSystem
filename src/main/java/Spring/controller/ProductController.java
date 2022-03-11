package Spring.controller;

import Spring.model.Product;
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
//    @PostMapping("/product")
//    public Product addProduct(@RequestBody Product product){
//        return productService.productRepository.save(product);
//    }


    @RequestMapping(method = RequestMethod.PUT,value ="/product/{id}")
    public void updateProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    //<------------ Delete Method ------------------->

//    @DeleteMapping("/product/{id}")
//    public Boolean deleteProduct(@PathVariable int id){
//        return productService.deleteProduct(id);
//    }

    @DeleteMapping("/deleteProduct/{name}")
    public Boolean deleteByProductName(@PathVariable String name){
        return productService.deleteByProductName(name);

    }

    @RequestMapping(method = RequestMethod.DELETE,value ="/deleteProduct/{id}")
    public Boolean deleteByProductId(@PathVariable int id){
        return productService.deleteByProductId(id);
    }

    @DeleteMapping("/product")
    public Boolean deleteProduct(@PathVariable Product product){
        return true;
    }

 //   <------------------ 2 --------------->


}
