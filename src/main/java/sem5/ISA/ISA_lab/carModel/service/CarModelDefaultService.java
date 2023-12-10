package sem5.ISA.ISA_lab.carModel.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sem5.ISA.ISA_lab.carMake.CarMake;
import sem5.ISA.ISA_lab.carMake.CarMakeRepo;
import sem5.ISA.ISA_lab.carModel.CarModel;
import sem5.ISA.ISA_lab.carModel.CarModelRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarModelDefaultService implements CarModelService{
    private final CarModelRepo carModelRepo;
    private final CarMakeRepo carMakeRepo;

    @Autowired
    public CarModelDefaultService(CarModelRepo carModelRepo, CarMakeRepo carMakeRepo) {
        this.carModelRepo = carModelRepo;
        this.carMakeRepo = carMakeRepo;
    }

    @Override
    public Optional<CarModel> find(UUID carModelId) {
        return carModelRepo.findById(carModelId);
    }

    @Override
    public Optional<CarModel> find(UUID carModelId, CarMake make) {
        return carModelRepo.findByCarModelIdAndMake(carModelId, make);
    }

    @Override
    public List<CarModel> findAll() {
        return carModelRepo.findAll();
    }

    @Override
    public List<CarModel> findAllByMake(CarMake make) {
        return carModelRepo.findAllByMake(make);
    }

    @Override
    public void save(CarModel model) {
        carModelRepo.save(model);
    }

    @Override
    public void update(CarModel model) {
        carModelRepo.save(model);
    }

    @Override
    public Optional<List<CarModel>> findAllByCarMakeId(UUID makeId) {
        return carMakeRepo.findById(makeId)
                .map(carModelRepo::findAllByMake);
    }

    @Override
    public void delete(UUID carModelId) {
        carModelRepo.deleteById(carModelId);
    }
}
