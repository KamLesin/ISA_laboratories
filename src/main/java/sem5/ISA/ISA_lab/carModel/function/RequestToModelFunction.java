package sem5.ISA.ISA_lab.carModel.function;

import org.springframework.stereotype.Component;
import sem5.ISA.ISA_lab.carModel.CarModel;
import sem5.ISA.ISA_lab.carModel.dto.PutModelRequest;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToModelFunction implements BiFunction<UUID, PutModelRequest, CarModel> {

    @Override
    public CarModel apply(UUID carModelId, PutModelRequest request) {
        return CarModel.builder()
                .carModelId(carModelId)
                .name(request.getName())
                .displacement(request.getDisplacement())
                .build();
    }
}
