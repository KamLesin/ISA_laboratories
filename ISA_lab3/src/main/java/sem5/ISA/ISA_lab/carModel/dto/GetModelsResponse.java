package sem5.ISA.ISA_lab.carModel.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetModelsResponse {

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

    @Singular
    private List<CarModel> models;
}
