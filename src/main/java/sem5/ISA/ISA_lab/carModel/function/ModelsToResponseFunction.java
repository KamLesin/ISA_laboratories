package sem5.ISA.ISA_lab.carModel.function;

import org.springframework.stereotype.Component;
import sem5.ISA.ISA_lab.carModel.CarModel;
import sem5.ISA.ISA_lab.carModel.dto.GetModelsResponse;

import java.util.List;
import java.util.function.Function;

@Component
public class ModelsToResponseFunction implements Function<List<CarModel>, GetModelsResponse> {

    @Override
    public GetModelsResponse apply(List<CarModel> models) {
        return GetModelsResponse.builder()
                .models(models.stream()
                        .map(model -> GetModelsResponse.CarModel.builder()
                                .carModelId(model.getCarModelId())
                                .name(model.getName())
                                .displacement(model.getDisplacement())
                                .build())
                        .toList())
                .build();
    }
}
