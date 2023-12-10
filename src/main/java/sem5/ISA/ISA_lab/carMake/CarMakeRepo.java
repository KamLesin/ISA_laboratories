package sem5.ISA.ISA_lab.carMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarMakeRepo extends JpaRepository<CarMake, UUID> {
    Optional<CarMake> findById(UUID carMakeId);

    Optional<CarMake> findByName(String name);
}
