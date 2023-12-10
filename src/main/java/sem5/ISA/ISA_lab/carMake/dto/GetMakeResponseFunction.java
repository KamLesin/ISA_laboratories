package sem5.ISA.ISA_lab.carMake.dto;

import org.springframework.stereotype.Component;
import sem5.ISA.ISA_lab.carMake.CarMake;

import java.util.function.Function;

@Component
public class GetMakeResponseFunction implements Function<CarMake, GetMakeResponse> {

    @Override
    public GetMakeResponse apply(CarMake make) {
        return GetMakeResponse.builder().build();
    }
}
