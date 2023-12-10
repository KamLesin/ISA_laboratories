package sem5.ISA.ISA_lab.carModel.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sem5.ISA.ISA_lab.carModel.dto.GetModelResponse;
import sem5.ISA.ISA_lab.carModel.dto.GetModelsResponse;
import sem5.ISA.ISA_lab.carModel.dto.PutModelRequest;

import java.util.UUID;

public interface ModelController {

    @GetMapping("/models")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetModelsResponse getModels();

    @GetMapping("/makes/{carMakeId}/models")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetModelsResponse getMakeModels(
            @PathVariable("carMakeId")
            UUID carMakeId
    );

    @GetMapping("/models/{carModelId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetModelResponse getModel(
            @PathVariable("carModelId")
            UUID carModelId
    );

    @GetMapping("/makes/{carMakeId}/models/{carModelId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetModelResponse getMakeModel(
            @PathVariable("carMakeId")
            UUID carMakeId,
            @PathVariable("carModelId")
            UUID carModelId
    );

    @PutMapping("/models/{carModelId}")
    @ResponseStatus(HttpStatus.CREATED)
    void putModel(
            @PathVariable("carModelId")
            UUID carModelId,
            @RequestBody
            PutModelRequest request
    );

    @DeleteMapping("/models/{carModelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteModel(
            @PathVariable("carModelId")
            UUID carModelId
    );
}
