package NguliaH.Pertemuan10;

class Node {
    int data;
    Node next;
    Node sibling;
    Node down;
    Node up;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.sibling = null;
        this.down = null;
        this.up = null;
    }
}

public class MultiLinkedList {
    Node head;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null)   {
                current = current.next;
            }
            current.next = newNode;  
        }
    }

    public void addSibling(Node node, Node sibling) {
        node.sibling = sibling;
    }

    public void addNodeToNewRow(Node node, int data) {
        Node newNode = new Node(data);
        node.down = newNode;
        newNode.up = node;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            Node sibling = current.sibling;
            while (sibling != null) {
                System.out.print(sibling.data + " ");
                sibling = sibling.sibling;
            }
            System.out.println();
            current = current.down;
            while (current != null) {
                System.out.print("  " + current.data + " -> ");
                sibling = current.sibling;
                while (sibling != null) {
                    System.out.print(sibling.data + " ");
                    sibling = sibling.sibling;
                }
                System.out.println();
                current = current.down;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        MultiLinkedList list = new MultiLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);

        Node node2 = list.head.next;
        Node node3 = list.head.next.next;

        list.addSibling(node2, new Node(4));
        list.addSibling(node2, new Node(5));
        list.addSibling(node3, new Node(6));

        list.addNodeToNewRow(node2, 7);
        list.addNodeToNewRow(node3, 8);

        list.printList();
    }
}
