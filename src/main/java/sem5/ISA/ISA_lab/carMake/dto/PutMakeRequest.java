package sem5.ISA.ISA_lab.carMake.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutMakeRequest {
    private String name;
    private int countryId;
}
