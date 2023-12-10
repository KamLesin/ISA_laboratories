package sem5.ISA.ISA_lab.carMake.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SaveMakeRequest {
    private String name;
    private int countryId;
}
