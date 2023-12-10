package sem5.ISA;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CarMake> makes = Data.CreateCarMakes();
        List<CarModel> models = Data.CreateCarModels();
        Data.connectData(models, makes);

        LabTasks tasks = new LabTasks();
        //tasks.Task2(makes);
        //tasks.Task3(makes);
        //tasks.Task4(makes);
        //tasks.Task5(models);
        //tasks.Task6(models);
        //tasks.Task7(makes);
    }
}