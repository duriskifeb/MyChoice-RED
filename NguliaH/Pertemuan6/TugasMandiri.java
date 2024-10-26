package NguliaH.Pertemuan6;

import java.util.Scanner;
//clas barang 
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
//class Node
class Node {
    Barang data;
    Node next;

    Node(Barang d) {
        data = d;
        next = null;
    }
}

public class TugasMandiri {
    Node top;
    Scanner inp = new Scanner(System.in);

    //ini untuk push
    public void push(Barang data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println("PUSH " + data.info());
    }

    //ini untuk pop
    public void pop() {
        if (top == null) {
            System.out.println("STACK KOSONG bruh!");
            return;
        }
        Node node = top;
        top = top.next;
        node.next = null;
        System.out.println("POP " + node.data.info());
    }
    //ini unutk delete
    public void delete(int id) {
        if (top == null) {
            System.out.println("STACK KOSONG");
            return;
        }
        if (top.data.getId() == id) {
            top = top.next;
            System.out.println("DELETE : " + id);
            return;
        }
        Node current = top;
        Node prev = top;
        while (current != null && current.data.getId() != id) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("DELETE : " + id + " NOT FOUND! bruh");
            return;
        }
        prev.next = current.next;
        System.out.println("DELETE : " + id);
    }
    //ini unutk print
    public void print() {
        if (top == null) {
            System.out.println("STACK KOSONG");
            return;
        }
        Node current = top;
        System.out.println();
        System.out.print("Stack : ");
        while (current != null) {
            System.out.print(current.data.info() + " | ");
            current = current.next;
        }
        System.out.println("");
    }
    //main
    public static void main(String[] args) {
        TugasMandiri sl = new TugasMandiri();
        sl.runThis();
    }
    //run jalan
    void runThis() {
        push(new Barang(1, "Barang Sate", 10));
        push(new Barang(2, "Barang Gule", 20));
        push(new Barang(3, "Barang Rawon", 30));
        push(new Barang(4, "Barang Soto", 40));
        push(new Barang(5, "Barang Bakso", 50));
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
