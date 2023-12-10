package sem5.ISA.ISA_lab.carMake.function;

import org.springframework.stereotype.Component;
import sem5.ISA.ISA_lab.carMake.CarMake;
import sem5.ISA.ISA_lab.carMake.dto.GetMakeResponse;

import java.util.function.Function;

@Component
public class MakeToResponseFunction implements Function<CarMake, GetMakeResponse> {
    @Override
    public GetMakeResponse apply(CarMake make){
        return GetMakeResponse.builder()
                .carMakeId(make.getCarMakeId())
                .name(make.getName())
                .countryId(make.getCountryId())
                .build();
    }
}
