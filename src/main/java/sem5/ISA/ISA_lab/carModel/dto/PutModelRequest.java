package sem5.ISA.ISA_lab.carModel.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutModelRequest {
    private String name;
    private int displacement;
}

