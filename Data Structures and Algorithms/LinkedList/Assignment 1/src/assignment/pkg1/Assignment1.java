/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author DELL
 */
public class Assignment1 {

    public static void main(String[] args) throws IOException {
        MyList m = new MyList();
        //Ex1
        m.readFromFile("products.txt");
        //Ex2
        System.out.println("Ex2");
        m.traverse();       
        //Ex3
        System.out.println("Ex3");
        double secondMax = m.secindMaxPriceNode();
        System.out.println(secondMax);
        m.delSecondMaxNode(secondMax);
        //Ex4
        System.out.println("Ex4");
        m.traverse();
        //Ex5
        System.out.println("Ex5");
        m.sortByName();
        m.traverse();
        
        //Ex6
        m.writeToFile("output.txt");
    }

}
