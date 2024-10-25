package NguliaH.Pertemuan6;


import java.io.*;
import java.util.Scanner;

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

    Node(Barang d) {
        data = d;
        next = null;
    }
}

public class Mandiri {
    Node top; // top of stack
    Scanner inp = new Scanner(System.in);

    public void push(Barang data) {
        Node newNode = new Node(data);

        if (top == null) {
            // Case 1: If stack is empty, set top to the new node
            top = newNode;
        } else {
            // Case 2: If stack has nodes, place the new node on top
            newNode.next = top;
            top = newNode;
        }
        System.out.println("PUSH " + data.info());
    }

    public void pop() {
        Node node = null;
        // Case 1: If stack is empty
        if (top == null) {
            // If stack is empty, provide information that stack is empty
            System.out.println("STACK KOSONG");
            return;
        } else {
            // If stack has nodes, pop the top node
            node = top; // Store the top node to return its data
            top = top.next; // Move top to the next node
            node.next = null; // Clear the next reference of the popped node
        }
        System.out.println("POP " + node.data.info());
    }

    public void delete(int id) {
        if (top == null) {
            // If stack is empty, provide information that stack is empty
            System.out.println("STACK KOSONG");
            return;
        }
        // Case 1: Delete the top node
        if (top.data.getId() == id) {
            if (top.next == null) {
                // If the next node of top is null, set top to null
                top = null;
            } else {
                top = top.next; // Move top to the next node
            }
            System.out.println("DELETE : " + id);
            return;
        }
        Node current = top; // Current node for iteration
        Node prev = top; // Previous node
        // Traverse to find the node
        while (current != null && current.data.getId() != id) {
            prev = current;
            current = current.next;
        }
        // If node not found, position is at the end
        if (current == null) {
            System.out.println("DELETE : " + id + " NOT FOUND");
            return;
        }
        // If node found in the middle or end
        if (current.next != null) {
            // If node is not the last one, link prev to current's next
            prev.next = current.next;
        } else {
            // If node is the last one, set next of prev to null
            prev.next = null;
        }
        System.out.println("DELETE : " + id);
        current = null; // Clear the current reference
    }

    public void print() {
        if (top == null) {
            // If stack is empty, display that the stack is empty
            System.out.println("STACK KOSONG");
            return;
        } else {
            Node current = top;
            System.out.print("Stack : ");
            // Iterate until the last node
            while (current != null) {
                System.out.print(current.data.info() + " | ");
                current = current.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Mandiri sl = new Mandiri();
        sl.runThis();
    }

    void runThis() {
        push(new Barang(1, "Barang A", 10));
        push(new Barang(2, "Barang B", 20));
        push(new Barang(3, "Barang C", 30));
        push(new Barang(4, "Barang D", 40));
        push(new Barang(5, "Barang E", 50));
        print();
        pop();
        print();
        pop();
        print();
        delete(3);
        print();
        delete(1);
        print();
        delete(5);
        print();
    }
}