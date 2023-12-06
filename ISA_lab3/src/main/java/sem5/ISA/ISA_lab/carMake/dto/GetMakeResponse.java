package sem5.ISA.ISA_lab.carMake.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetMakeResponse {

    //Single Model
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CarModel {
        private UUID carModelId;
        private String name;
        private int displacement;
    }

    private UUID carMakeId;
    private String name;
    private int countryId;
    @Singular
    private List<CarModel> models;
}
