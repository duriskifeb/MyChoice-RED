package NguliaH.Pertemuan7;

class Pasien {
    int noUrut; // Nomor urut pasien
    String nama; // Nama pasien

    // Constructor untuk Pasien
    Pasien(int nu, String nama) {
        this.noUrut = nu;
        this.nama = nama;
    }

    // Mengembalikan informasi pasien
    String info() {
        return noUrut + " " + nama;
    }

    // Mendapatkan nomor urut pasien
    int getNoUrut() {
        return noUrut;
    }
}

class Node {
    Pasien data; // Data pasien
    Node next; // Pointer ke node berikutnya

    // Constructor untuk Node
    Node(Pasien d) {
        data = d;
        next = null;
    }
}

public class QueueListPasien {
    private Node head; // Kepala dari list
    private Node tail; // Ekor dari list
    private int lastNoUrut = 0; // Untuk menyimpan nomor urut terakhir

    // Tambah antrian baru
    public void enqueue(String nama) {
        lastNoUrut++; // Increment nomor urut
        Pasien newPasien = new Pasien(lastNoUrut, nama);
        Node newNode = new Node(newPasien);

        if (head == null) { // Jika list kosong
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // Tambahkan ke akhir
            tail = newNode; // Update tail
        }
        System.out.println("Pasien baru " + newPasien.info() + " ditambahkan");
    }

    // Hapus pasien dari depan
    public void dequeue() {
        if (head == null) { // Jika list kosong
            System.out.println("List kosong");
        } else {
            Pasien removedPatient = head.data; // Ambil data pasien yang dihapus
            head = head.next; // Update head
            if (head == null) { // Jika list menjadi kosong
                tail = null;
            }
            System.out.println("Data diambil: " + removedPatient.info());
        }
    }

    // Ambil pasien berdasarkan no urut
    public void ambilAntrianTengah(int noUrut) {
        if (head == null) { // Jika list kosong
            System.out.println("List kosong");
            return;
        }

        Node current = head;
        Node prev = null;

        // Mencari pasien dengan nomor urut yang diberikan
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
            if (head == null) { // Jika list menjadi kosong
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

    // Cetak daftar pasien
    public void printList() {
        Node current = head;
        System.out.println("Daftar antrian : ");
        while (current != null) {
            System.out.println(current.data.info());
            current = current.next;
        }
        System.out.println("");
    }

    // Main method untuk menjalankan contoh
    public static void main(String[] args) {
        QueueListPasien queue = new QueueListPasien();
        queue.enqueue("Gandalf The Grey");
        queue.enqueue("Aragorn");
        queue.enqueue("Legolas");
        queue.enqueue("Gimli");
        queue.enqueue("Boromir");
        queue.enqueue("Frodo Baggins");
        queue.enqueue("Samwise Gamgee");
        queue.enqueue("Meri");
        queue.enqueue("Pippin");
        queue.printList();

        queue.ambilAntrianTengah(5); // Coba ambil pasien dengan noUrut 5
        queue.printList();

        queue.dequeue(); // Dequeue pasien pertama
        queue.printList();

        queue.enqueue("Gandalf The White"); // Tambah pasien baru
        queue.printList();
    }
}