package sem5.ISA.ISA_lab.carMake.function;

import org.springframework.stereotype.Component;
import sem5.ISA.ISA_lab.carMake.CarMake;
import sem5.ISA.ISA_lab.carMake.dto.PutMakeRequest;

import java.util.function.BiFunction;
import java.util.UUID;

@Component
public class RequestToMakeFunction implements BiFunction<UUID, PutMakeRequest, CarMake> {

    @Override
    public CarMake apply(UUID id, PutMakeRequest request){
        return CarMake.builder()
                .carMakeId(id)
                .name(request.getName())
                .countryId(request.getCountryId())
                .build();
    }
}
