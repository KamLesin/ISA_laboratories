package sem5.ISA.ISA_lab.carModel.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetModelResponse {

    // Single Make

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CarMake {
        private UUID carMakeId;
        private String name;
        private int countryId;
    }

    private UUID carModelId;
    private String name;
    private int displacement;
    private CarMake make;
}
