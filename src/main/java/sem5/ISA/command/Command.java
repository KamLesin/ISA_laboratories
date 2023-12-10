package sem5.ISA.ISA_lab.command;
import sem5.ISA.ISA_lab.carMake.CarMakeService;
import sem5.ISA.ISA_lab.carModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sem5.ISA.ISA_lab.carMake.CarMakeRepo;

import java.util.Scanner;
import java.util.UUID;

@Component
public class Command implements CommandLineRunner {
    private final CarMakeService carMakeService;
    private final CarModelService carModelService;

    @Autowired
    public Command(CarMakeService carMakeService, CarModelService carModelService) {
        this.carMakeService = carMakeService;
        this.carModelService = carModelService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            System.out.println("1. List Categories");
            System.out.println("2. List Elements");
            System.out.println("3. Add New Element");
            System.out.println("4. Delete Element");
            System.out.println("5. Exit");

            command = scanner.next();
            switch (command) {
                case "1" -> {
                    carMakeService.listCategories().forEach(System.out::println);
                }
                case "2" -> {
                    carModelService.listElements().forEach(System.out::println);
                }
                case "3" -> {
                    System.out.print("Model ID: ");
                    String carModelId = scanner.next();
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Displacement: ");
                    int displacement = scanner.nextInt();
                    System.out.print("Make ID: ");
                    String carMakeId = scanner.next();
                    carModelService.addElement(carModelId, name, displacement, UUID.fromString(carMakeId));
                    System.out.println("Success!");
                }
                case "4" -> {
                    System.out.print("Model ID: ");
                    String carModelId = scanner.next();
                    carModelService.deleteElement(UUID.fromString(carModelId));
                    System.out.println("Success!");
                }
                case "5" -> {
                    System.exit(0);
                    break main_loop;
                }
                default -> {
                    System.out.println("Invalid command.");
                }
            }
        }
    }
}
