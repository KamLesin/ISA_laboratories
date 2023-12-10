package sem5.ISA.ISA_lab.carMake.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sem5.ISA.ISA_lab.carMake.dto.GetMakeResponse;
import sem5.ISA.ISA_lab.carMake.dto.GetMakesResponse;
import sem5.ISA.ISA_lab.carMake.function.MakeToResponseFunction;
import sem5.ISA.ISA_lab.carMake.function.MakesToResponseFunction;
import sem5.ISA.ISA_lab.carMake.service.CarMakeService;

import java.util.UUID;

@RestController
@Log
public class MakeDefaultController implements MakeController{

    private final CarMakeService service;
    private final MakeToResponseFunction makeToResponseFunction;
    private final MakesToResponseFunction makesToResponseFunction;

    @Autowired
    public MakeDefaultController(CarMakeService service, MakeToResponseFunction makeToResponseFunction,
                                 MakesToResponseFunction makesToResponseFunction) {
        this.service = service;
        this.makeToResponseFunction = makeToResponseFunction;
        this.makesToResponseFunction = makesToResponseFunction;
    }


    @Override
    public GetMakesResponse getMakes() {
        return makesToResponseFunction.apply(service.findAll());
    }

    @Override
    public GetMakeResponse getMake(UUID CarMakeId) {
        return service.find(CarMakeId).map(makeToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteCarMake(UUID CarMakeId) {
        service.find(CarMakeId)
                .ifPresentOrElse(
                        make -> service.delete(CarMakeId),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
