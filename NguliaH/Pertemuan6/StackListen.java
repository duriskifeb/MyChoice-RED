package NguliaH.Pertemuan6;

import java.util.Scanner;

class Oden {
    String data;
    Oden next;

    Oden(String d) {
        data = d;
        next = null;
    }
}

public class StackListen {
    Oden top;
    Scanner input = new Scanner(System.in);

    public void push(String data) {
        Oden newNode = new Oden(data);

        // logic operasion
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println("Pushing " + data);
    }

    // ini yang dari pop
    public void pop() {
        Oden popden = null;
        // logic this pop
        if (top == null) {
            System.out.println("Stack kosong kak");
            return;
        } else {
            popden = top;
            top = top.next;
            popden.next = null;
        }
        System.out.println("Pop " + popden.data);
    }

    // this delete method
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
        Oden current = top; // Current Oden for iteration
        Oden prev = top; // Previous node
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

    //Buat print 
    public void printStack() {
        if (top == null) {
            System.out.println("Stack ini kosong kak...");
            return;
        }else{
            Oden current = top;
            System.out.println("\nStack : ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println("");
        }
    }
    /**
     * InnerLearnNyel
     */
    public static void main(String[] args) {
        StackListen Ln = new StackListen();
        Ln.runThis();
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
        printStack();
        pop();
        printStack();
        pop();
        printStack();
        delete("struktur");
        printStack();
        delete("kita");
        printStack();
        delete("stack");
        printStack();
    }
    
}
