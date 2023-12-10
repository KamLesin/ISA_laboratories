package sem5.ISA.ISA_lab.carMake.function;

import sem5.ISA.ISA_lab.carMake.CarMake;
import sem5.ISA.ISA_lab.carMake.dto.PatchMakeRequest;

import java.util.function.BiFunction;

public class UpdateCustomerWithRequestFunction implements BiFunction<CarMake, PatchMakeRequest, CarMake> {

    @Override
    public CarMake apply(CarMake make, PatchMakeRequest request) {
        return CarMake.builder()
                .carMakeId(make.getCarMakeId())
                .name(request.getName())
                .countryId(request.getCountryId())
                .build();
    }
}
