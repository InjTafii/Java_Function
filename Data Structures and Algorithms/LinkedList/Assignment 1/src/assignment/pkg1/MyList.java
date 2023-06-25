package assignment.pkg1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyList {

    Node head, tail;
    int size;

    MyList() {
        head = tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    public void addLast(Product x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }

    public void addLastMany(String[] a, String[] b, int[] c, double[] d) {
        for (int i = 0; i < a.length; i++) {
            addLast(new Product(a[i], b[i], c[i], d[i]));
        }
    }

    
    void readFromFile(String fileName) throws IOException {
        String a = "P03 | Sugar | 12 | 25.1\nP01 | Miliket | 10 | 5.2\nP02 | Apple | 5 | 4.3\nP10 | Cookies | 9 | 6.5\nP05 | Rose | 7 | 15.4\nP07 | Beer | 11 | 12.2\nP04 | Book | 9 | 5.2";
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(a);
        bw.close();
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String arr[] = line.split(" [|] ");
            String pocode = arr[0].trim();
            String productName = arr[1].trim();
            int quantity = Integer.parseInt(arr[2].trim());
            double price = Double.parseDouble(arr[3].trim());

            Product x = new Product(pocode, productName, quantity, price);
            if(!x.proName.contains("Cookie") || x.price > 30)
            {
                addLast(x);
            }
            
        }
        br.close();
        fr.close();
    }

    
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info.toString());
            p = p.next;
        }
    }

    
    void dele(Node p) {
        if (p == null) {
            return;
        }
        if (isEmpty()) {
            return;
        }
        Node f, q;
        f = null;
        q = head;
        while (q != null) {
            if (p == q) {
                break;
            }
            f = q;
            q = q.next;
        }
        if (q == null) {
            return;
        }
        if (f == null) {
            head = head.next;
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }

    
    void sortByName() {
        Node pi, pj;
        Product x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.proName.compareToIgnoreCase(pi.info.proName)>0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    
    public void writeToFile(String fileName) throws IOException {
        Node p = head;
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        while (p != null) {
            bw.write(p.info.toString());
            bw.newLine();
            p = p.next;
        }
        bw.close();
        fw.close();
    }

    
    Double secindMaxPriceNode() {
        Node p = head;
        double firstMax = p.info.price;
        double secondMax = p.next.info.price;
        while (p != tail) {
            if (p.info.price > firstMax) {
                secondMax = firstMax;
                firstMax = p.info.price;
            } else if(firstMax > p.info.price && secondMax < p.info.price){
                secondMax = p.info.price;
            }
            p = p.next;
        }
        return secondMax;
    }

    void delSecondMaxNode(double secondMax) {
        Node p = head;
        while (p != null) {
            if (p.info.price == secondMax) {
                dele(p);
                break;
            } else {
                p = p.next;
            }
        }
    }

}
