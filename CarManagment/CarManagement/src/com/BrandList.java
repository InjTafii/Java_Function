package com;

import com.*;
import java.io.*;
import java.util.*;

public class BrandList {

    ArrayList<Brand> listBr;
    Menu menu;
    private ArrayList<String> options;
    private int num;

    public BrandList() {
        listBr = new ArrayList<>();
        num = 0;
    }

    public boolean loadFromFile(String filename) throws FileNotFoundException, IOException {

        File f = new File(filename);
        if (!f.exists()) {
            System.out.println("Does not file");
            System.exit(1);
        } else {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",:");
                String brandID = st.nextToken().trim();
                String brandName = st.nextToken().trim();
                String soundBrand = st.nextToken().trim();
                double price = Double.parseDouble(st.nextToken().trim());
                Brand p1 = new Brand(brandID, brandName, soundBrand, price);
                listBr.add(num, p1);
                num++;
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
                for (int i = 0; i < num; i++) {
                    pw.println(listBr.get(i).toString());
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

    public int searchID(String bID) {
        for (int i = 0; i < num; i++) {
            if (listBr.get(i).getBrandID().toUpperCase().equals(bID.toUpperCase())) {
                return i;
            }
        }
        return -1;
    }

    public Brand getUserChoice() {
        return (Brand) menu.ref_getChoice(options);
    }

    public void addBrand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Brand ID: ");
        String Brands = sc.nextLine().trim();
        int same = searchID(Brands);
        while (same != -1) {
            System.out.println("Brand ID exist in the list ");
            System.out.print("Brand ID: ");
            Brands = sc.nextLine().trim();
            same = searchID(Brands);
        }

        System.out.print("Brand Name: ");
        String brandName = sc.nextLine().trim();
        while (isBlank(brandName) == true) {
            System.out.println("Brand Name is not blank ");
            System.out.print("Brand Name: ");
            brandName = sc.nextLine().trim();
        }

        System.out.print("Sound Brand: ");
        String soundBrand = sc.nextLine().trim();
        while (isBlank(soundBrand) == true) {
            System.out.println("Sound Brand is not blank ");
            System.out.print("Sound Brand: ");
            soundBrand = sc.nextLine().trim();
        }

        sc = new Scanner(System.in);
        System.out.print("Price: ");
        double price = sc.nextDouble();
        while (price <= 0) {
            System.out.println("Price > 0");
            System.out.print("Price: ");
            price = sc.nextDouble();
        }
        Brand br = new Brand(Brands, brandName, soundBrand, price);
        listBr.add(num, br);
        num++;

    }

    public void updateBrand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Brand ID: ");
        String Brands = sc.nextLine().trim();
        int same = searchID(Brands);
        if (same < 0) {
            System.out.println("Not found!");
        } else {
            System.out.print("Brand Name: ");
            String brandName = sc.nextLine();
            while (isBlank(brandName) == true) {
                System.out.println("Brand Name is not blank ");
                System.out.print("Brand Name: ");
                brandName = sc.nextLine().trim();
            }

            System.out.print("Sound Brand: ");
            String soundBrand = sc.nextLine();
            while (isBlank(soundBrand) == true) {
                System.out.println("Sound Brand is not blank ");
                System.out.print("Sound Brand: ");
                soundBrand = sc.nextLine().trim();
            }

            sc = new Scanner(System.in);
            System.out.print("Price: ");
            double price = sc.nextDouble();
            while (price <= 0) {
                System.out.println("Price > 0");
                System.out.print("Price: ");
                price = sc.nextDouble();
            }
            Brand br = new Brand(Brands.trim(), brandName.trim(), soundBrand.trim(), price);
            listBr.set(same, br);
            System.err.println("Success");
        }

    }

    public void listBrands() {
        for (int i = 0; i < num; i++) {
            System.out.println(listBr.get(i).toString());
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

    public ArrayList<Brand> getListBr() {
        return listBr;
    }

    public void setListBr(ArrayList<Brand> listBr) {
        this.listBr = listBr;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
