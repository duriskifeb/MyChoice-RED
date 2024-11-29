package NguliaH.Pertemuan10;

class Node {
    int data;
    Node next;
    Node sibling;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.sibling = null;
    }
}

public class LatihanBeforeClassing {

    Noded head;

    public void addNode() {
        if (head == null) {
            head = newNode;
        }else {
            Node current = head;
            while (current.next!= null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public static void main(String[] args) {
        System.out.println("riski anak baik");
        System.out.println("alhamdulillah");
    }
}
