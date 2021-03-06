package Spring.controller;

import Spring.model.Inventory;
import Spring.model.Product;
import Spring.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService){
    this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory")
    public List<Inventory> getAllInventory(){return inventoryService.findAll();}

    @RequestMapping(value = "/inventoryId/{id}", method = RequestMethod.GET)
    public Inventory getInventoryById(@PathVariable int id){
        return inventoryService.getInventoryById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/saveInventory/{id}")
    public void saveInventory(@RequestBody Inventory inventory){
        inventoryService.saveInventory(inventory);
    }

    @DeleteMapping("/deleteInventory/{inventory}")
    public Boolean deleteProduct(@PathVariable Inventory inventory){
        inventoryService.deleteInventory(inventory);
        System.out.println(inventory.toString() + " was deleted from list of products");
        return true;
    }

}
