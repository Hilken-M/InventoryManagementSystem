package Spring.controller;

import Spring.model.Store;
import Spring.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService){this.storeService = storeService;}

    @GetMapping("/store")
    public List<Store> getAllStores(){return storeService.findAll();}

    @RequestMapping(value = "/storeId/{id}", method = RequestMethod.GET)
    public Store getStoreById(@PathVariable int id){
        return storeService.getStoreById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/saveStore/{id}")
    public void saveStore(@RequestBody Store store){
        storeService.saveStore(store);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/deleteStore/{id}")
    public Boolean deleteStoreId(@RequestBody int id){
        return storeService.deleteStoreId(id);
    }


}
