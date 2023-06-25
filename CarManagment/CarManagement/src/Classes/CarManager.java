package Classes;

import com.*;
import java.io.*;
import java.util.*;

public class CarManager {

    BrandList br;
    CarList car;
    Scanner sc;

    public CarManager() {
        br = new BrandList();
        car = new CarList(br);
    }

    public static void main(String[] args) throws IOException {
        CarManager cs = new CarManager();
        cs.program();
    }

    public void program() {
        try {
            Menu menu = new Menu();
            sc = new Scanner(System.in);
            ArrayList ops = new ArrayList<>();
            CarManager cs = new CarManager();
            String textBr ="CarPri\\brands.txt";
            String textCa ="CarPri\\cars.txt";
            ops.add("-List all brands");
            ops.add("-Add a new brand");
            ops.add("-Search a brand based on its ID ");
            ops.add("-Update a brand");
            ops.add("-Save brands to the file, named brands.txt");
            ops.add("-List all cars in ascending order of brand names");
            ops.add("-List cars based on a part of an input brand name ");
            ops.add("-Add a car");
            ops.add("-Remove a car based on its ID");
            ops.add("-Update a car based on its ID");
            ops.add("-Save cars to file, named cars.txt");
            cs.br.loadFromFile(textBr);
            cs.car.loadFromFile(textCa);
            int choice;
            do {
                choice = menu.int_getChoice(ops);
                switch (choice) {
                    case 1:
                        System.out.println("\n==================================");
                        cs.br.listBrands();
                        System.out.println("==================================\n");
                        break;
                    case 2:
                        cs.addBr();
                        break;
                    case 3:
                        cs.searchBrId();
                        break;
                    case 4:
                        cs.updateBa();
                        break;
                    case 5:
                        System.out.println("\n==================================");
                        cs.br.saveToFile(textBr);
                        System.out.println("==================================\n");
                        break;
                    case 6:
                        System.out.println("\n==================================");
                        cs.car.listCars();
                        System.out.println("==================================\n");
                        break;
                    case 7:
                        cs.listCarBa();
                        break;
                    case 8:
                        cs.addCa();
                        break;
                    case 9:
                        cs.removeCa();
                        break;
                    case 10:
                        cs.updateCa();
                        break;
                    case 11:
                        System.out.println("\n==================================");
                        cs.car.saveToFile(textCa);
                        System.out.println("==================================\n");
                        break;
                }
            } while (choice > 0 && choice <= ops.size());
        } catch (Exception e) {
            program();
        }
    }

    public void addBr() {
        try {
            System.out.println("\n==================================");
            br.addBrand();
            System.out.println("==================================\n");
        } catch (Exception e) {
            addBr();
        }
    }

    public void searchBrId() {
        try {
            System.out.println("\n==================================");
            System.out.print("Brand ID: ");
            String bID = sc.nextLine().trim();
            int i = br.searchID(bID);
            if (i == -1) {
                System.out.println("Not found!");
            } else {
                System.out.println(br.getListBr().get(i).toString());
            }
            System.out.println("==================================\n");
        } catch (Exception e) {
            searchBrId();
        }
    }

    public void updateBa() {
        try {
            System.out.println("\n==================================");
            br.updateBrand();
            System.out.println("==================================\n");
        } catch (Exception e) {
            updateBa();
        }
    }

    public void listCarBa() {
        try {
            System.out.println("\n==================================");
            car.printBasedBrandName();
            System.out.println("==================================\n");
        } catch (Exception e) {
            listCarBa();
        }
    }

    public void addCa() {
        try {
            System.out.println("\n==================================");
            car.addCar();
            System.out.println("==================================\n");
        } catch (Exception e) {
            addCa();
        }
    }

    public void removeCa() {
        try {
            System.out.println("\n==================================");
            car.removeCar();
            System.out.println("==================================\n");
        } catch (Exception e) {
            removeCa();
        }
    }

    public void updateCa() {
        try {
            System.out.println("\n==================================");
            car.updateCar();
            System.out.println("==================================\n");
        } catch (Exception e) {
            updateCa();
        }
    }
}
