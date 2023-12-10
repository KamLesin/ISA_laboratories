package sem5.ISA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data {
    public static void connectData(List<CarModel> models, List<CarMake> makes){
//        int j = 0;
//        List<CarModel> copy = new ArrayList<>();
//        copy.addAll(models);
//        ArrayList<CarModel> temp = new ArrayList<>();
//        for (CarMake make : makes) {
//            temp.add(copy.get(j));
//            temp.add(copy.get(j + 1));
//            make.setModels(temp);
//            models.get(j).setMake(make);
//            models.get(j + 1).setMake(make);
//            j += 2;
//        }
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
        carModels.add(CarModel.builder().name("Supra").displacement(2997).make(null).build());
        carModels.add(CarModel.builder().name("Camry").displacement(3000).make(null).build());
        carModels.add(CarModel.builder().name("Civic").displacement(1998).make(null).build());
        carModels.add(CarModel.builder().name("NSX").displacement(3499).make(null).build());
        carModels.add(CarModel.builder().name("GT-R").displacement(3600).make(null).build());
        carModels.add(CarModel.builder().name("Primera").displacement(2000).make(null).build());
        carModels.add(CarModel.builder().name("911").displacement(4000).make(null).build());
        carModels.add(CarModel.builder().name("Cayman").displacement(2600).make(null).build());
        carModels.add(CarModel.builder().name("i20").displacement(1400).make(null).build());
        carModels.add(CarModel.builder().name("i30").displacement(1600).make(null).build());
        return carModels;
    }

    public static List<CarMake> CreateCarMakes(){
        List<CarMake> carMakes = new ArrayList<>();
        carMakes.add(CarMake.builder().name("Toyota").countryId(1).models(new ArrayList<>()).build());
        carMakes.add(CarMake.builder().name("Honda").countryId(1).models(new ArrayList<>()).build());
        carMakes.add(CarMake.builder().name("Nissan").countryId(1).models(new ArrayList<>()).build());
        carMakes.add(CarMake.builder().name("Porsche").countryId(2).models(new ArrayList<>()).build());
        carMakes.add(CarMake.builder().name("Hyundai").countryId(3).models(new ArrayList<>()).build());
        return carMakes;
    }
}
