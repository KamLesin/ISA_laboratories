package sem5.ISA.ISA_lab.carModel.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetModelResponse {

    private UUID carModelId;
    private String name;
    private int displacement;
    private UUID carMakeId;
}
