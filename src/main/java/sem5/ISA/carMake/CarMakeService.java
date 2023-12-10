package sem5.ISA.carMake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CarMakeService {
    private final CarMakeRepo carMakeRepo;

    @Autowired
    public CarMakeService(CarMakeRepo carMakeRepo) {
        this.carMakeRepo = carMakeRepo;
    }

    @Transactional
    public List<CarMake> listCategories() {
        List<CarMake> customers = carMakeRepo.findAll();
        if (customers.isEmpty()) {
            System.out.println("No categories found.");
        }
        return customers;
    }


    public CarMake save(CarMake carMake) {
        return carMakeRepo.save(carMake);
    }

    public CarMake getCustomerById(UUID carMakeId) {
        return carMakeRepo.findById(carMakeId).orElse(null);
    }
}