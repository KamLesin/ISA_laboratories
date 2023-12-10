package sem5.ISA.ISA_lab.carModel.service;

import sem5.ISA.ISA_lab.carMake.CarMake;
import sem5.ISA.ISA_lab.carModel.CarModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarModelService {

    Optional<CarModel> find(UUID carModelId);

    Optional<CarModel> find(UUID carModelId, CarMake make);

    List<CarModel> findAll();

    List<CarModel> findAllByMake(CarMake make);

    void save(CarModel model);

    void update(CarModel model);

    Optional<List<CarModel>> findAllByCarMakeId(UUID makeId);

    void delete(UUID carModelId);

}
