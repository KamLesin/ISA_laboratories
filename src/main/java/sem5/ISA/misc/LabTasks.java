package sem5.ISA.misc;

import sem5.ISA.carMake.CarMake;
import sem5.ISA.carModel.CarModel;
import sem5.ISA.carModel.CarModelDTO;
import sem5.ISA.mapToDTO.ToDTO;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class LabTasks {

    public void Task2(List<CarMake> makes){
        makes.forEach(carMake -> {
            System.out.println("Make: " + carMake.getName() + ", CountryID: " + carMake.getCountryId() + ":");
            carMake.getModels().forEach(carModel -> System.out.println("Model: " + carModel.getName()
                    + ", Displacement: " + carModel.getDisplacement()));
        });
    }

    public void Task3(List<CarMake> makes){
        makes.stream().flatMap(carMake -> carMake.getModels()
                .stream()).collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    public void Task4(List<CarMake> makes){
        makes.stream().flatMap(carMake -> carMake.getModels().stream())
                .filter(carModel -> carModel.getDisplacement() > 2000)
                .sorted(Comparator.comparing(CarModel::getName))
                .forEach(System.out::println);
    }

    public void Task5(List<CarModel> carModels){
        carModels.stream().map(ToDTO::toCarModelDTO)
                .sorted(Comparator.comparing(CarModelDTO::getName).thenComparingInt(CarModelDTO::getDisplacement))
                .forEach(System.out::println);
    }

    public void Task6(List<CarModel> carModels){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.bin"));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.bin"))) {

            objectOutputStream.writeObject(carModels);
            List<CarModel> carModels1 = (List<CarModel>) objectInputStream.readObject();
            carModels1.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
        }
    }

    public void Task7(List<CarMake> makes) {
        int poolSize = 1;
        ForkJoinPool threadPool = new ForkJoinPool(poolSize);
        try { threadPool.submit(() -> {
           makes.parallelStream().forEach(make -> {
               try {
                   TimeUnit.SECONDS.sleep(1);
                   System.out.println(make.getName());
               } catch (Exception e){
                    e.printStackTrace();
               }
           });
        });
        } finally {
            threadPool.shutdown();
        }
        try {
            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
