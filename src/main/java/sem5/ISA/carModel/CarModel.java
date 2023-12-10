package sem5.ISA.carModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import sem5.ISA.carMake.CarMake;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "car_models")
@AllArgsConstructor
@NoArgsConstructor
public class CarModel implements Comparable<CarModel>, Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "carModelId", updatable = false, nullable = false)
    private UUID carModelId;
    @Column(name = "name")
    private String name;
    @Column(name = "displacement")
    private int displacement;
    @ManyToOne
    @JoinColumn(name = "car_make_id")
    private CarMake make;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(carModelId, carModel.carModelId) &&
                Objects.equals(name, carModel.name) &&
                Objects.equals(displacement, carModel.displacement) &&
                Objects.equals(make, carModel.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carModelId, name, displacement, make);
    }

    @Override
    public int compareTo(CarModel carModel) {
        return this.carModelId.compareTo(carModel.carModelId);
    }

    @Override
    public String toString() {
        return carModelId + ". Model: " + name + ", Displacement: " + displacement + ", Make: " + make.getName();
    }
}
