package sem5.ISA.ISA_lab.carMake.service;

import sem5.ISA.ISA_lab.carMake.CarMake;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarMakeService {

    List<CarMake> findAll();

    Optional<CarMake> find(UUID CarMakeId);

    Optional<CarMake> find(String name);

    void save(CarMake make);

    void delete(UUID CarMakeId);
}
