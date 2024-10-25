package NguliaH.Pertemuan6;

import java.io.*;
import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String d) {
        data = d;
        next = null;
    }
}

public class StackList {
    Node top; // top of stack
    Scanner inp = new Scanner(System.in);

    public void push(String data) {
        Node newNode = new Node(data);

        if (top == null) {
            // Case 1: If stack is empty, set top to the new node
            top = newNode;
        } else {
            // Case 2: If stack has nodes, place the new node on top
            newNode.next = top;
            top = newNode;
        }
        System.out.println("PUSH " + data);
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
        System.out.println("POP " + node.data);
    }

    public void delete(String data) {
        if (top == null) {
            // If stack is empty, provide information that stack is empty
            System.out.println("STACK KOSONG");
            return;
        }
        // Case 1: Delete the top node
        if (top.data.equals(data)) {
            if (top.next == null) {
                // If the next node of top is null, set top to null
                top = null;
            } else {
                top = top.next; // Move top to the next node
            }
            System.out.println("DELETE : " + data);
            return;
        }
        Node current = top; // Current node for iteration
        Node prev = top; // Previous node
        // Traverse to find the node
        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }
        // If node not found, position is at the end
        if (current == null) {
            System.out.println("DELETE : " + data + " NOT FOUND");
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
        System.out.println("DELETE : " + data);
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
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        StackList sl = new StackList();
        sl.runThis();
    }

    void runThis() {
        push("hari");
        push("ini");
        push("kita");
        push("mempelajari");
        push("materi");
        push("struktur");
        push("data");
        push("tentang");
        push("stack");
        print();
        pop();
        print();
        pop();
        print();
        delete("struktur");
        print();
        delete("kita");
        print();
        delete("stack");
        print();
    }
}