package sem5.ISA.ISA_lab.carModel.controller;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sem5.ISA.ISA_lab.carModel.dto.GetModelResponse;
import sem5.ISA.ISA_lab.carModel.dto.GetModelsResponse;
import sem5.ISA.ISA_lab.carModel.dto.PutModelRequest;
import sem5.ISA.ISA_lab.carModel.function.ModelToResponseFunction;
import sem5.ISA.ISA_lab.carModel.function.ModelsToResponseFunction;
import sem5.ISA.ISA_lab.carModel.function.RequestToModelFunction;
import sem5.ISA.ISA_lab.carModel.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@RestController
@Log
public class ModelDefaultController implements ModelController{

    private final CarModelService carModelService;

    private final ModelToResponseFunction modelToResponseFunction;

    private final ModelsToResponseFunction modelsToResponseFunction;

    private final RequestToModelFunction requestToModelFunction;

    @Autowired
    public ModelDefaultController(
            CarModelService carModelService, ModelToResponseFunction modelToResponseFunction,
            ModelsToResponseFunction modelsToResponseFunction, RequestToModelFunction requestToModelFunction) {
        this.carModelService = carModelService;
        this.modelToResponseFunction = modelToResponseFunction;
        this.modelsToResponseFunction = modelsToResponseFunction;
        this.requestToModelFunction = requestToModelFunction;
    }
    @Override
    public GetModelsResponse getModels() {
        return modelsToResponseFunction.apply(carModelService.findAll());
    }

    @Override
    public GetModelsResponse getMakeModels(UUID carMakeId) {
        return carModelService.findAllByCarMakeId(carMakeId)
                .map(modelsToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetModelResponse getModel(UUID carModelId) {
        return carModelService.find(carModelId)
                .map(modelToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetModelResponse getMakeModel(UUID carMakeId, UUID carModelId) {
        return null;
    }

    @Override
    public void putModel(UUID carModelId, PutModelRequest request) {
        carModelService.save(requestToModelFunction.apply(carModelId, request));
    }

    @Override
    public void deleteModel(UUID carModelId) {
        carModelService.find(carModelId)
                .ifPresentOrElse(
                        order -> carModelService.delete(carModelId),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
