package sem5.ISA.ISA_lab.carMake.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sem5.ISA.ISA_lab.carMake.dto.GetMakeResponse;
import sem5.ISA.ISA_lab.carMake.dto.GetMakesResponse;

import java.util.UUID;

public interface MakeController {

    @GetMapping("/makes")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMakesResponse getMakes();

    @GetMapping("/makes/{CarMakeId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMakeResponse getMake(
            @PathVariable("CarMakeId") UUID CarMakeId
    );

    @DeleteMapping("/makes/{CarMakeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCarMake(
            @PathVariable("CarMakeId") UUID CarMakeId
    );

}
