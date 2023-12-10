package sem5.ISA.carModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarModelRepo extends JpaRepository<CarModel, UUID> {
    List<CarModel> findByCarModelId(UUID carModelId);
}
