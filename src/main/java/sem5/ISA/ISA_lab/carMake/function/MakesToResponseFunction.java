package sem5.ISA.ISA_lab.carMake.function;

import org.springframework.stereotype.Component;
import sem5.ISA.ISA_lab.carMake.CarMake;
import sem5.ISA.ISA_lab.carMake.dto.GetMakesResponse;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MakesToResponseFunction implements Function<List<CarMake>, GetMakesResponse> {

    @Override
    public GetMakesResponse apply(List<CarMake> makes){
        return GetMakesResponse.builder()
                .makes(makes.stream()
                        .map(make -> GetMakesResponse.CarMake.builder()
                                .carMakeId(make.getCarMakeId())
                                .name(make.getName())
                                .countryId(make.getCountryId())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
