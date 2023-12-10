package sem5.ISA.ISA_lab.carModel.function;

import sem5.ISA.ISA_lab.carModel.CarModel;
import sem5.ISA.ISA_lab.carModel.dto.PatchModelRequest;

import java.util.function.BiFunction;

public class UpdateModelWithRequestFunction implements BiFunction<CarModel, PatchModelRequest, CarModel> {

    @Override
    public CarModel apply(CarModel model, PatchModelRequest request) {
        return CarModel.builder()
                .carModelId(model.getCarModelId())
                .name(request.getName())
                .displacement(request.getDisplacement())
                .make(model.getMake())
                .build();
    }
}
