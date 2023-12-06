package sem5.ISA.ISA_lab.carModel;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder

public class CarModelDTO implements Serializable {
    private UUID carModelId;
    private String name;
    private int displacement;
    private String make;
}
