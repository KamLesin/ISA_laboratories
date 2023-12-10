package sem5.ISA.mapToDTO;

import sem5.ISA.carModel.CarModel;
import sem5.ISA.carModel.CarModelDTO;

public class ToDTO {
    public static CarModelDTO toCarModelDTO(CarModel model){
        return CarModelDTO.builder()
                .name(model.getName())
                .displacement(model.getDisplacement())
                .make(model.getMake().getName())
                .build();
    }
}
