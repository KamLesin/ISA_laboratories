package sem5.ISA;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder

public class CarModel implements Serializable {
    String name;
    int displacement;
    CarMake make;

    @Override
    public String toString() {
        return "Model: " + name + ", Displacement: " + displacement + ", Make: " + make.getName();
    }
}
