package Spring.service;

import Spring.model.Product;
import Spring.model.Store;
import Spring.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;


@Component
public class StoreService {

    @Autowired
    public StoreRepository storeRepository;
    public Object updateStore;

    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Store getStoreById(int id) {
        return storeRepository.getStoreById(id);
    }

    public void deleteInventory(Store store) {
        storeRepository.delete(store);
    }

    public Store saveStore(Store store) {
       return storeRepository.save(store);
    }
}
