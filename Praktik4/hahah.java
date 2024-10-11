package Praktik4;

public class hahah {

    class Barang {
        private int id;
        private String nama;
        private int stok;

        public Barang(int id, String nama, int stok) {
            this.id = id;
            this.nama = nama;
            this.stok = stok;
        }

        public int getId() {
            return id;
        }

        public String info() {
            return id + " " + nama + " " + stok;
        }
    }

    class Node {
        Barang data;
        Node next;

        Node(Barang b) {
            data = b;
            next = null;
        }
    }

    Node head; // Head of the list

    // Method to insert a node at the end (not sorted)
    public void insert(Barang data) {
        Node nn = new Node(data); // Create new node
        Node current = head;

        // If the list is empty
        if (current == null) {
            head = nn;
        } else {
            // Find the last node
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn; // Add the new node at the end
        }

        System.out.println("Node baru " + data.info() + " ditambahkan di akhir list");
    }

    // Method to insert a node in sorted order (ascending) by id
    public void insertSorted(Barang data) {
        Node nn = new Node(data); // Create new node

        // If the list is empty or the new node should be the first
        if (head == null || head.data.getId() > nn.data.getId()) {
            nn.next = head;
            head = nn;
        } else {
            // Find the correct position to insert the new node
            Node current = head;
            while (current.next != null && current.next.data.getId() < nn.data.getId()) {
                current = current.next;
            }
            nn.next = current.next;
            current.next = nn;
        }

        System.out.println("Node baru " + data.info() + " ditambahkan secara terurut");
    }

    // Method to delete a node by id
    public void delete(int id) {
        if (head == null) {
            System.out.println("List kosong");
            return;
        }

        // If the node to be deleted is the head
        if (head.data.getId() == id) {
            head = head.next;
            System.out.println("Node " + id + " telah dihapus");
            return;
        }

        // Searching for the node to delete
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.data.getId() == id) {
                previous.next = current.next; // Bypass the node to delete
                System.out.println("Node " + id + " telah dihapus");
                return;
            }
            previous = current;
            current = current.next;
        }

        // If the node is not found
        System.out.println("Node " + id + " tidak ditemukan");
    }

    // Method to print the list
    public void printList() {
        Node current = head;
        System.out.print("Single LinkedList: ");
        while (current != null) {
            System.out.print(current.data.info() + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to run the program
    public static void main(String[] args) {
        hahah sll = new hahah();
        sll.runThis();
    }

    // Method to run sample data insertion and deletion
    void runThis() {
        System.out.println("================================================");

        // Insert items not sorted
        insert(new Barang(5, "So So", 55));
        insert(new Barang(2, "Clean", 22));
        insert(new Barang(1, "So", 11));

        System.out.println("================================================");

        // Insert items sorted
        insertSorted(new Barang(8, "So So Clean", 88));
        insertSorted(new Barang(3, "So Clean", 33));
        insertSorted(new Barang(6, "Clean Clean", 66));
        insertSorted(new Barang(7, "So Clean So Clean", 77));
        insertSorted(new Barang(10, "Clean So So", 100));
        insertSorted(new Barang(9, "So Clean Clean", 99));
        insertSorted(new Barang(4, "Clean So", 44));

        System.out.println("================================================");
        printList();

        // Deleting elements
        delete(4);
        delete(1);
        delete(10);
        delete(99);

        printList();
        System.out.println("================================================");
    }
}
