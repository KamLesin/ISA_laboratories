package sem5.ISA.ISA_lab.carMake;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import sem5.ISA.ISA_lab.carModel.CarModel;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "car_makes")
@AllArgsConstructor
@NoArgsConstructor
public class CarMake implements Comparable<CarMake>, Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "car_make_id", updatable = false, nullable = false)
    private UUID carMakeId;
    @Column(name = "name")
    private String name;
    @Column(name = "country_id")
    private int countryId;
    @OneToMany(mappedBy = "make",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CarModel> models;

    @Override
    public String toString() {
        List<String> modelsNames = models.stream().map(CarModel::getName).toList();
        return carMakeId + ". Make: " + name + ", CountryID: " + countryId + ", models: " + modelsNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMake carMake = (CarMake) o;
        return Objects.equals(carMakeId, carMake.carMakeId) &&
                Objects.equals(name, carMake.name) &&
                Objects.equals(countryId, carMake.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carMakeId, name, countryId, models);
    }

    @Override
    public int compareTo(CarMake otherMake) {
        return this.name.compareTo(otherMake.name);
    }
}
