package sem5.ISA;

public class ToDTO {
    public static CarModelDTO toCarModelDTO(CarModel model){
        return CarModelDTO.builder()
                .name(model.getName())
                .displacement(model.getDisplacement())
                .make(model.getMake().getName())
                .build();
    }
}
