package NguliaH.Pertemuan7;

import java.io.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class JurnalTerbimbing {
    Node head; // head of list
    Node tail; // tail of list

    /* Insert last */
    public int enqueue(int data) {
        Node nn = new Node(data);
        if (head == null) { // Jika list kosong
            head = nn;
            tail = nn;
        } else {
            tail.next = nn; // tambahkan di akhir
            tail = nn;
        }
        System.out.println("Node baru " + data + " ditambahkan");
        return 0;
    }

    /* Dequeue */
    public int dequeue() {
        Node current = head;
        if (head == null) { // Jika list kosong
            System.out.println("List kosong");
            return 0;
        } else if (head == tail) { // Jika hanya ada satu elemen
            head = null;
            tail = null;
        } else {
            current = head;
            head = head.next;
            current.next = null;
        }
        System.out.println("Data diambil " + current.data);
        return 0;
    }

    public void printList() {
        Node current = head;
        System.out.print("Daftar antrian: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        JurnalTerbimbing sll = new JurnalTerbimbing();
        sll.runThis();
    }

    void runThis() {
        enqueue(1);
        enqueue(5);
        enqueue(3);
        enqueue(2);
        enqueue(7);
        enqueue(6);
        enqueue(9);
        enqueue(8);
        printList();
        dequeue();
        printList();
        dequeue();
        printList();
        dequeue();
        printList();
    }
}
