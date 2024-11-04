package NguliaH.Pertemuan7;

import java.util.Optional;

class Pasien {
    private final int noUrut;
    private final String nama;

    Pasien(int noUrut, String nama) {
        this.noUrut = noUrut;
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

    Node(Pasien data) {
        this.data = data;
        this.next = null;
    }
}

public class JurnalMandiri {
    private Node head; 
    private Node tail; 
    private int lastNoUrut = 0; 

    /**
     * Menambahkan pasien baru ke dalam antrian menggunakan param :).
     *
     * @param nama = pasien
     */
    public void enqueue(String nama) {
        lastNoUrut++;
        Pasien newPasien = new Pasien(lastNoUrut, nama);
        Node newNode = new Node(newPasien);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        System.out.println("Pasien baru " + newPasien.info() + " ditambahkan" + "\n");
    }

    // menggunakan dequee
    public void dequeue() {
        if (head == null) {
            System.out.println("List kosong");
            return;
        }

        Pasien removedPatient = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        System.out.println("Data diambil: " + removedPatient.info());
    }

    /**
     * Mengambil pasien dengan nomor urut tertentu dari tengah antrian menggunakan param.
     *
     * @param noUrut Nomor urut pasien yang ingin diambil
     */

    // -> mengamil dari urutan ke tenghah ya :)
    public void ambilAntrianTengah(int noUrut) {
        if (head == null) {
            System.out.println("List kosong");
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null && current.data.getNoUrut() != noUrut) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Pasien dengan no urut " + noUrut + " tidak ditemukan");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            prev.next = current.next;
            if (current == tail) {
                tail = prev;
            }
        }

        System.out.println("Pasien diambil: " + current.data.info());
    }

    // Menampilkan seluruh daftar antrian menggunakan printList ya.. :).
    public void printList() {
        System.out.println("Daftar antrian : ");
        Node current = head;
        while (current != null) {
            System.out.println(current.data.info());
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        JurnalMandiri queue = new JurnalMandiri();
        queue.run();
    }

    //runThis untuk memanggil semua yang telah di perlukan
    private void run() {
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
