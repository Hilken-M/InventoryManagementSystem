package Spring.service;

import Spring.model.Inventory;
import Spring.model.Product;
import Spring.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;
@Component
public class InventoryService {

    @Autowired
    public InventoryRepository inventoryRepository;
    public Object updateInventory;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(int id) {
        return inventoryRepository.getInventoryById(id);
    }

    public void saveInventory(Inventory inventory) {
         inventoryRepository.save(inventory);
    }

    public void deleteInventory(Inventory inventory) {
        inventoryRepository.delete(inventory);
    }


}
