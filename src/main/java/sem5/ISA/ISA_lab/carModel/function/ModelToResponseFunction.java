package sem5.ISA.ISA_lab.carModel.function;

import org.springframework.stereotype.Component;
import sem5.ISA.ISA_lab.carModel.CarModel;
import sem5.ISA.ISA_lab.carModel.dto.GetModelResponse;

import java.util.function.Function;


@Component
public class ModelToResponseFunction implements Function<CarModel, GetModelResponse> {

    @Override
    public GetModelResponse apply(CarModel model) {
        return GetModelResponse.builder()
                .carModelId(model.getCarModelId())
                .name(model.getName())
                .displacement(model.getDisplacement())
                .carMakeId(model.getMake().getCarMakeId()) // Assuming Customer has getId() method
                .build();
    }
}
