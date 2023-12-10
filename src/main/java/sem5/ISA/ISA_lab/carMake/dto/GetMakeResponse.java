package sem5.ISA.ISA_lab.carMake.dto;

import lombok.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetMakeResponse {
    private UUID carMakeId;
    private String name;
    private int countryId;
}
