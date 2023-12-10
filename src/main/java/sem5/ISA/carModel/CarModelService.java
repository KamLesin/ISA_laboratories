package sem5.ISA.carModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sem5.ISA.carMake.CarMake;
import sem5.ISA.carMake.CarMakeRepo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CarModelService {
    private final CarModelRepo carModelRepo;
    private final CarMakeRepo carMakeRepo;

    @Autowired
    public CarModelService(CarModelRepo carModelRepo, CarMakeRepo carMakeRepo) {
        this.carModelRepo = carModelRepo;
        this.carMakeRepo = carMakeRepo;
    }

    @Transactional
    public List<CarModel> listElements() {
        List<CarModel> elements = carModelRepo.findAll();
        if (elements.isEmpty()) {
            System.out.println("No elements found.");
        }
        return elements;
    }

    public void addElement(String carModelId, String name, int displacement, UUID carMakeId) {
        CarMake carMake = carMakeRepo.findById(carMakeId)
                .orElseThrow(() -> new EntityNotFoundException("Make not found"));

        CarModel order = CarModel.builder()
                .carModelId(UUID.fromString(carModelId))
                .name(name)
                .displacement(displacement)
                .make(carMake)
                .build();

        carModelRepo.save(order);
    }

    @Transactional
    public void deleteElement(UUID carModelId) {
        CarModel carModel = carModelRepo.findById(carModelId)
                .orElseThrow(() -> new NoSuchElementException("Model not found"));

        carModel.getMake().getModels().remove(carModel);

        carModelRepo.deleteById(carModelId);
    }

    public List<CarModel> getCarModelsById(CarModel carModel) {
        return carModelRepo.findByCarModelId(carModel.getCarModelId());
    }

    public CarModel save(CarModel carModel) {
        return carModelRepo.save(carModel);
    }
}
