package NguliaH;

import java.io.*;

class Pasien {
    int noUrut;
    String nama;

    Pasien(int nu, String nama) {
        this.noUrut = nu;
        this.nama = nama;
    }

    String info() {
        return noUrut + " " + nama;
    }

    int getNoUrut() {
        return noUrut;
    }
}

class Node {
    Pasien data;
    Node next;

    Node(Pasien d) {
        data = d;
        next = null;
    }
}

public class MisalNih {
    Node head; // head of list
    Node tail; // tail of list
    int lastNoUrut = 0; // last assigned patient number

    /* Tambah antrian */
    public void enqueue(String nama) {
        // Pastikan bahwa no urut pasien akan selalu terurut, sehingga
        // Jika Queue kosong, no urut dari 1
        // Jika Queue tidak kosong, no urut diambil dari no urut last node +1
        lastNoUrut++;
        Pasien newPasien = new Pasien(lastNoUrut, nama);
        Node newNode = new Node(newPasien);

        if (head == null) { // Jika Queue kosong
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // Tambahkan ke akhir
            tail = newNode; // Update tail
        }
        System.out.println("Pasien baru " + newPasien.info() + " ditambahkan");
    }

    /* Ambil Urutan */
    public void dequeue() {
        // Pengambilan node urutan dari yang paling ujung
        if (head == null) { // Jika Queue kosong
            System.out.println("List kosong");
        } else {
            Pasien removedPatient = head.data; // Ambil data pasien yang dihapus
            head = head.next; // Update head
            if (head == null) { // Jika Queue menjadi kosong
                tail = null;
            }
            System.out.println("Data diambil: " + removedPatient.info());
        }
    }

    /* jika no antrian depan tidak ada, maka ambil antrian yang ada */
    public void ambilAntrianTengah(int noUrut) {
        // Jika list kosong
        if (head == null) {
            System.out.println("List kosong");
            return;
        }

        Node current = head;
        Node prev = null;

        // Jika pasien yang datang sesuai no urut tidak ada, maka akan diambil nextnya
        // sampai ketemu
        while (current != null && current.data.getNoUrut() != noUrut) {
            prev = current;
            current = current.next;
        }

        if (current == null) { // Jika pasien tidak ditemukan
            System.out.println("Pasien dengan no urut " + noUrut + " tidak ditemukan");
            return;
        }

        // Menghapus node yang ditemukan
        if (current == head) { // Jika node yang dihapus adalah head
            head = head.next;
            if (head == null) { // Jika Queue menjadi kosong
                tail = null;
            }
        } else {
            prev.next = current.next; // Bypass current node
            if (current == tail) { // Jika node yang dihapus adalah tail
                tail = prev; // Update tail
            }
        }

        System.out.println("Pasien diambil: " + current.data.info());
    }

    public void printList() {
        Node current = head;
        System.out.println("Daftar antrian : ");
        while (current != null) {
            System.out.println(current.data.info());
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MisalNih sll = new MisalNih();
        sll.runThis();
    }

    void runThis() {
        enqueue("Gandalf The Grey");
        enqueue("Aragorn");
        enqueue("Legolas");
        enqueue("Gimli");
        enqueue("Boromir");
        enqueue("Frodo Baggins");
        enqueue("Samwise Gamgee");
        enqueue("Meri");
        enqueue("Pippin");
        printList();
        ambilAntrianTengah(5);
        printList();
        dequeue();
        printList();
        enqueue("Gandalf The White");
        printList();
    }
}