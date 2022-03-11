package Spring.service;

import Spring.model.Inventory;
import Spring.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
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

    public Boolean deleteInventoryId(int id) {
        System.out.println("Inventory id: "+id+ " has been deleted");
        return inventoryRepository.deleteByInventoryId(id);
    }
}
