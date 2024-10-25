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
    //getter setter
    public int getId() {
        return id;
    }
    public String info() {
        return id + " " + " " + stok;
    }
}

class Nodeel {
    Barang data;
    Nodeel next;

    Nodeel(Barang b) {
        data = b;
        next = null;
    }
}
/**
 * TugasMandiri
 */
public class TugasMandiri {
    Nodeel top;
    Scanner input = new Scanner(System.in);

    public void push(Barang data) {
        Nodeel newNode = new Nodeel(data); 

        if (top == null) {
            top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println("Push : " + data.info());
    }

    //pop method
    public void pop() {
        Nodeel temp = null;
        if (top == null) {
            System.out.println("Stack kosong kak!");
            return;
        }else {
            
        }

    }
}