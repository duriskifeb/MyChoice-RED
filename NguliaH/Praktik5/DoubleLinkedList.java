package NguliaH.Praktik5;

import java.util.Scanner;

//kelas ini sama dengan objek ya :)
class Node {
    int data;
    Node next;
    Node prev;

    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
}

public class DoubleLinkedList {
    Node head; // kepala node
    Node tail; // 
    Scanner inp = new Scanner(System.in);

    /* Insert last */
    public void insertEnd(int data) {
        Node nn = new Node(data);
        if (tail == null) {
            head = tail = nn;
        } else {
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }
        System.out.println("Node baru " + data + " di posisi belakang");
        System.out.println();
    }

    /* Insert First */
    public void insertFirst(int data) {
        Node nn = new Node(data);
        if (head == null) {
            head = tail = nn;
        } else {
            head.prev = nn;
            nn.next = head;
            head = nn;
        }
        System.out.println("Node baru " + data + " di posisi depan");
    }

    /* Insert sorted */
    public void insertSorted(int data) {
        Node newNode = new Node(data);

        // Kasus 1. Jika List kosong
        if (head == null) {
            head = tail = newNode;
            System.out.println("Node baru " + data + " paling depan");
            return;
        }

        // Kasus 2. Jika new node adalah angka paling kecil
        if (data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            System.out.println("Node baru " + data + " paling depan");
            return;
        }

        // Kasus 3: Jika new node angka paling besar
        if (data >= tail.data) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            System.out.println("Node baru " + data + " paling belakang");
            return;
        }

        // Kasus 4: Diantara head dan tail
        Node current = head;
        while (current != null && current.data < data) {
            current = current.next;
        }

        // Insert the node before the current node
        newNode.next = current;
        newNode.prev = current.prev;

        if (current.prev != null) {
            current.prev.next = newNode;
        }
        current.prev = newNode;
        System.out.println("Node baru " + data + " di tengah");
    }

    // Delete node dengan data tertentu
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;

        // Case 1: Delete the head node
        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // If the list becomes empty
            }
            System.out.println("Node " + data + " dihapus dari depan.");
            return;
        }

        // Traverse to find the node to delete
        while (current != null && current.data != data) {
            current = current.next;
        }

        // Case 2: Node not found
        if (current == null) {
            System.out.println("Node " + data + " tidak ditemukan.");
            return;
        }

        // Case 3: Delete a middle node
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev; // Jika node yang dihapus adalah tail
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
        System.out.println("Node " + data + " dihapus.");
    }

    public void printListBackward() {
        Node current = head;
        System.out.print("Double LinkedList Backward: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printListForward() {
        Node current = tail;
        System.out.print("Double LinkedList Forward: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.runThis();
    }

    void runThis() {
        // INSERT BIASA
        insertFirst(1);
        insertEnd(5);
        insertEnd(3);
        insertFirst(2);
        insertFirst(7);
        insertEnd(6);
        insertFirst(9);
        insertEnd(8);
        printListBackward();
        printListForward();

        // INSERT SORTED
        insertSorted(1);
        insertSorted(5);
        insertSorted(3);
        insertSorted(2);
        insertSorted(7);
        insertSorted(6);
        insertSorted(9);
        insertSorted(8);
        printListBackward();
        printListForward();

        // DELETE TEST
        delete(6);
        printListBackward();
        delete(1);
        printListBackward();
        delete(9);
        printListBackward();
    }
}
