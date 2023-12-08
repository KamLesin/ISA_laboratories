package sem5.ISA.ISA_lab.carMake.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetMakesResponse {

    //Single Make

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CarMake {
        private UUID carMakeId;
        private String name;
        private int countryId;
    }

    @Singular
    private List<CarMake> makes;
}
