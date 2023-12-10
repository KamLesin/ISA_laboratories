package sem5.ISA.ISA_lab.carModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sem5.ISA.ISA_lab.carMake.CarMake;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarModelRepo extends JpaRepository<CarModel, UUID> {
    List<CarModel> findByCarModelId(UUID carModelId);

    Optional<CarModel> findByCarModelIdAndMake(UUID OrderId, CarMake make);

    List<CarModel> findAllByMake(CarMake make);
}
