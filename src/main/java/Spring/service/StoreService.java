package Spring.service;

import Spring.model.Store;
import Spring.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
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

    public Boolean deleteStoreId(int id) {
        System.out.println("Store id: "+id+ " has been deleted");
        return storeRepository.deleteByStoreId(id);
    }

    public Store saveStore(Store store) {
       return storeRepository.save(store);
    }
}
