package assignment.pkg1;

public class Node {

    public Product info;
    public Node next;

    public Node() {
    }

    public Node(Product info) {
        this.info = info;
        this.next = null;
    }

    public Node(Product info, Node next) {
        this.info = info;
        this.next = next;
    }

    @Override
    public String toString() {
        return  info + ", " + next ;
    }
    
}
