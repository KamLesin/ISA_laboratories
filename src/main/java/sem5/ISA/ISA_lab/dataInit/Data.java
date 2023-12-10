package sem5.ISA.ISA_lab.dataInit;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sem5.ISA.ISA_lab.carMake.CarMake;
import sem5.ISA.ISA_lab.carMake.service.CarMakeDefaultService;
import sem5.ISA.ISA_lab.carModel.CarModel;
import sem5.ISA.ISA_lab.carModel.CarModelService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Data {
    private final CarMakeDefaultService carMakeDefaultService;
    private final CarModelService carModelService;

    @Autowired
    public Data(CarMakeDefaultService carMakeDefaultService, CarModelService carModelService) {
        this.carMakeDefaultService = carMakeDefaultService;
        this.carModelService = carModelService;
    }
    public static void connectData(List<CarModel> models, List<CarMake> makes){
        int j = 0;
        for (CarMake make : makes) {
            make.getModels().add(models.get(j));
            make.getModels().add(models.get(j + 1));
            models.get(j).setMake(make);
            models.get(j + 1).setMake(make);
            j += 2;
        }
    }

    public static List<CarModel> CreateCarModels(){
        List<CarModel> carModels = new ArrayList<>();
        carModels.add(CarModel.builder().carModelId(UUID.randomUUID()).name("Supra")
                .displacement(2997).make(null).build());
        carModels.add(CarModel.builder().carModelId(UUID.randomUUID()).name("Camry")
                .displacement(3000).make(null).build());
        carModels.add(CarModel.builder().carModelId(UUID.randomUUID()).name("Civic")
                .displacement(1998).make(null).build());
        carModels.add(CarModel.builder().carModelId(UUID.randomUUID()).name("NSX")
                .displacement(3499).make(null).build());
        carModels.add(CarModel.builder().carModelId(UUID.randomUUID()).name("GT-R")
                .displacement(3600).make(null).build());
        carModels.add(CarModel.builder().carModelId(UUID.randomUUID()).name("Primera")
                .displacement(2000).make(null).build());
        carModels.add(CarModel.builder().carModelId(UUID.randomUUID()).name("911")
                .displacement(4000).make(null).build());
        carModels.add(CarModel.builder().carModelId(UUID.randomUUID()).name("Cayman")
                .displacement(2600).make(null).build());
        carModels.add(CarModel.builder().carModelId(UUID.randomUUID()).name("i20")
                .displacement(1400).make(null).build());
        carModels.add(CarModel.builder().carModelId(UUID.randomUUID()).name("i30")
                .displacement(1600).make(null).build());
        return carModels;
    }

    public static List<CarMake> CreateCarMakes(){
        List<CarMake> carMakes = new ArrayList<>();
        carMakes.add(CarMake.builder().carMakeId(UUID.randomUUID()).name("Toyota").countryId(1)
                .models(new ArrayList<>()).build());
        carMakes.add(CarMake.builder().carMakeId(UUID.randomUUID()).name("Honda").countryId(1)
                .models(new ArrayList<>()).build());
        carMakes.add(CarMake.builder().carMakeId(UUID.randomUUID()).name("Nissan").countryId(1)
                .models(new ArrayList<>()).build());
        carMakes.add(CarMake.builder().carMakeId(UUID.randomUUID()).name("Porsche").countryId(2)
                .models(new ArrayList<>()).build());
        carMakes.add(CarMake.builder().carMakeId(UUID.randomUUID()).name("Hyundai").countryId(3)
                .models(new ArrayList<>()).build());
        return carMakes;
    }

    @PostConstruct
    public void populateDatabase(){
        List<CarModel> models = CreateCarModels();
        List<CarMake> makes = CreateCarMakes();
        connectData(models, makes);

        for (CarMake make : makes) {
            carMakeDefaultService.save(make);
        }
        for (CarModel model : models) {
            carModelService.save(model);
        }
    }
}
