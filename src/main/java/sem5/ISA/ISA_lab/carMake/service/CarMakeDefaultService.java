package sem5.ISA.ISA_lab.carMake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sem5.ISA.ISA_lab.carMake.CarMake;
import sem5.ISA.ISA_lab.carMake.CarMakeRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarMakeDefaultService implements CarMakeService {

    private final CarMakeRepo carMakeRepo;

    @Autowired
    public CarMakeDefaultService(CarMakeRepo carMakeRepo) {
        this.carMakeRepo = carMakeRepo;
    }

    @Override
    public List<CarMake> findAll() {
        return carMakeRepo.findAll();
    }

    @Override
    public Optional<CarMake> find(UUID CarMakeId) {
        return carMakeRepo.findById(CarMakeId);
    }

    @Override
    public Optional<CarMake> find(String name) {
        return carMakeRepo.findByName(name);
    }

    @Override
    public void save(CarMake make) {
        carMakeRepo.save(make);
    }

    @Override
    public void delete(UUID CarMakeId) {
        carMakeRepo.findById(CarMakeId).ifPresent(carMakeRepo::delete);
    }
}