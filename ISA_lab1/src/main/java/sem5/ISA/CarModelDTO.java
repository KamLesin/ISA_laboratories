package sem5.ISA;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder

public class CarModelDTO implements Serializable {
    String name;
    int displacement;
    String make;
}
