package sem5.ISA;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder

public class CarMake implements Serializable {
    String name;
    int countryId;
    @EqualsAndHashCode.Exclude
    List<CarModel> models;

    @Override
    public String toString() {
        List<String> modelsNames = models.stream().map(CarModel::getName).toList();
        return "Make: " + name + ", CountryID: " + countryId + ", models: " + modelsNames;
    }
}
