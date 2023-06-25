package com;

import java.util.*;

public class Menu<E> {
        BrandList brandList;

    private ArrayList<E> options;

    public int int_getChoice(ArrayList<E> options) {
        Scanner sc = new Scanner(System.in);
        int N = options.size() ;
           for (int i = 0; i < N; i++) {
               System.out.println((i+1)+" "+options.get(i).toString());
        }
        System.out.println("Please choose an option 1..."+N);
        int response = sc.nextInt();
        return response;

    }

    @Override
    public String toString() {
        return  "options=" + options ;
    }

    public E ref_getChoice(ArrayList<E> options) {
        int N = options.size();
        int response;
        do {
            response = int_getChoice(options);
        } while (response < 0 || response > N);
        return options.get(response - 1);
    }

}
