package com;

import com.*;
import java.io.*;
import java.util.*;

public class CarList {

    Menu menu = new Menu();
    BrandList brandList;
    ArrayList<Car> listCar;
    int num1;
    Scanner sc;

    public CarList(BrandList bList) {
        brandList = bList;
        listCar = new ArrayList<>();
        num1 = 0;
    }

    public boolean loadFromFile(String filename) throws FileNotFoundException, IOException {
        File f = new File(filename);
        if (!f.exists()) {
            return false;
        } else {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    StringTokenizer st = new StringTokenizer(line, ",");
                    String carID = st.nextToken().trim();
                    String Brands = st.nextToken().trim();
                    int pos = brandList.searchID(Brands);
                    Brand b = brandList.listBr.get(pos);
                    String color = st.nextToken().trim();
                    String frameID = st.nextToken().trim();
                    String engineID = st.nextToken().trim();
                    Car p1 = new Car(carID, b, color, frameID, engineID);
                    listCar.add(num1, p1);
                    num1++;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            br.close();
            fr.close();
        }
        return true;
    }

    public boolean saveToFile(String filename) {
        File f = new File(filename);
        boolean result = false;
        try {
            if (f.isFile() && f.canWrite()) {
                FileWriter fw = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fw);
                for (int i = 0; i < num1; i++) {
                    pw.println(listCar.get(i).toString());
                }
                result = true;
                System.err.println("Successful");
                fw.close();
                pw.close();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return result;
    }

    public int searchID(String ID) {
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getCarID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String fID) {
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getFrameID().equalsIgnoreCase(fID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchEngine(String eID) {
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getEngineID().equalsIgnoreCase(eID)) {
                return i;
            }
        }
        return -1;
    }

    public void addCar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Car ID: ");
        String cars = sc.nextLine().trim();
        int same = searchID(cars);
        while (same != -1) {
            System.out.println("Car ID exist in the list ");
            System.out.print("Car ID: ");
            cars = sc.nextLine().trim();
            same = searchID(cars);
        }
        Brand b = (Brand) menu.ref_getChoice(brandList.listBr);

        System.out.print("Color: ");
        String color = sc.nextLine().trim();
        while (isBlank(color) == true) {
            System.out.println("Color is not blank ");
            System.out.print("Color: ");
            color = sc.nextLine().trim();
        }
        String frameID = checkfan("F");
        String engineID = checken("E");
        Car ca = new Car(cars, b, color, frameID, engineID);
        listCar.add(num1, ca);
        num1++;

    }

    public String checkfan(String s) {
        for (int i = 0; i < listCar.size(); i++) {

            int Exit = searchFrame(init(s, i));
            if (Exit == -1) {
                return init(s, i);
            }
        }
        return init(s, listCar.size());

    }

    public String checken(String s) {
        for (int i = 0; i < listCar.size(); i++) {

            int Exit = searchEngine(init(s, i));
            if (Exit == -1) {
                return init(s, i);
            }
        }
        return init(s, listCar.size());
    }

    public String init(String s, int i) {
        if (i < 10) {
            return s + "0000" + i;
        } else if (i >= 10 && i < 100) {
            return s + "000" + i;
        } else if (i >= 100 && i < 1000) {
            return s + "00" + i;
        } else if (i >= 1000 && i < 10000) {
            return s + "0" + i;
        } else {
            return s + i;
        }
    }

    public void printBasedBrandName() {
        sc = new Scanner(System.in);
        int N = listCar.size();
        int count = 0;
        System.out.print("Enter a part of brand name: ");
        String aPartOfBrandName = sc.nextLine().trim();
        for (int i = 0; i < N - 1; i++) {
            Car c = listCar.get(i);
            if (c.getBrand().getBrandName().contains(aPartOfBrandName)) {
                System.out.println(c.screenString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No car is detected!");
        }
    }

    public boolean removeCar() {
        sc = new Scanner(System.in);
        System.out.print("Car ID: ");
        String i = sc.nextLine().trim();
        int pos = searchID(i);
        if (pos == -1) {
            System.out.println("Not found!");
            return false;
        } else {
            num1--;
            listCar.remove(pos);
            System.err.println("Successfully");
        }
        return true;

    }

    public boolean updateCar() {
        sc = new Scanner(System.in);
        System.out.print("ID: ");
        String updatedID = sc.nextLine().trim();
        int pos = searchID(updatedID);
        if (pos == -1) {
            System.out.println("Not found!");
            return false;
        } else {
            Brand b = (Brand) menu.ref_getChoice(brandList.listBr);
            System.out.print("Color: ");
            String color = sc.nextLine().trim();
            while (isBlank(color) == true) {
                System.out.println("Color is not blank ");
                System.out.print("Color: ");
                color = sc.nextLine().trim();
            }
            String frameID = checkfan("F");
            String engineID = checken("E");
            Car ca = new Car(updatedID, b, color, frameID, engineID);
            listCar.set(pos, ca);

        }
        return true;
    }

    public void listCars() {
        listCar.sort(new Comparator<Car>() {
            @Override
            public int compare(Car t, Car t1) {
                if (t.getBrand().brandName.compareTo(t1.getBrand().brandName) > 0) {
                    return 1;
                } else if (t.getBrand().brandName.compareTo(t1.getBrand().brandName) < 0) {
                    return -1;
                }
                return 0;
            }
        });

        for (int i = 0; i < listCar.size(); i++) {
            System.out.println(listCar.get(i).screenString());
        }
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
}
