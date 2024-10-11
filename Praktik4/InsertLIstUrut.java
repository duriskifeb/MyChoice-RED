package Praktik4;

// Kelas Node untuk membentuk struktur dari Linked List

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

    Node(Barang b) {
        data = b;
        next = null;
    }
}

public class InsertLIstUrut {
    Node head; // Head dari list

    // Metode untuk menyisipkan node secara terurut (dari kecil ke besar)
    public void insertSorted(int data) {
        Node nn = new Node(Barang); // Membuat node baru
        Node current = head;

        // Jika list kosong atau data lebih kecil dari head
        if (head == null || head.data >= nn.data) {
            nn.next = head;
            head = nn;
        } else {
            // Mencari posisi yang tepat untuk menyisipkan node
            while (current.next != null && current.next.data < nn.data) {
                current = current.next;
            }
            nn.next = current.next;
            current.next = nn;
        }
        System.out.println("Node baru " + data + " ditambahkan secara terurut");
    }

    // Metode untuk menghapus node
    public int delete(int data) {
        // Jika list kosong
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        }

        // Jika data ada di head
        if (head.data == data) {
            head = head.next;
            System.out.println("Node " + data + " telah dihapus");
            return 0;
        }

        // Mencari node dengan data yang sesuai
        Node current = head;
        Node prec = head;

        while (current != null) {
            if (current.data == data) {
                prec.next = current.next;
                current.next = null;
                System.out.println("Node " + data + " telah dihapus");
                return 0;
            }
            prec = current;
            current = current.next;
        }

        // Jika data tidak ditemukan
        System.out.println("Node " + data + " tidak ditemukan");
        return 0;
    }

    // Metode untuk mencetak list berdasarkan urutan di dalam linked list
    public void printList() {
        Node current = head;
        System.out.print("Single LinkedList : ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Metode utama untuk menjalankan program
    public static void main(String[] args) {
        InsertLIstUrut sll = new InsertLIstUrut();
        sll.runThis();
    }

    // Metode untuk menjalankan contoh pengisian data
    void runThis() {
        // Menggunakan insertSorted untuk memasukkan data secara urut
        /*
         * Buka komentar untuk menjalankan
         * insert(new Barang(5, "So So", 55));
         * insert(new Barang(2, "Clean", 22));
         * insert(new Barang(1, "So", 11));
         * insert(new Barang(8, "So So Clean", 88));
         * insert(new Barang(3, "So Clean", 33));
         * insert(new Barang(6, "Clean Clean", 66));
         * insert(new Barang(7, "So Clean So Clean", 77));
         * insert(new Barang(10, "Clean So So", 100));
         * insert(new Barang(9, "So Clean Clean", 99));
         * insert(new Barang(4, "Clean So", 44));
         */
        /*
         * Buka komentar untuk menjalankan
         * insertSorted(new Barang(5, "So So", 17));
         * insertSorted(new Barang(2, "Clean", 65));
         * insertSorted(new Barang(1, "So", 15));
         * insertSorted(new Barang(8, "So So Clean", 32));
         * insertSorted(new Barang(3, "So Clean", 41));
         * insertSorted(new Barang(6, "Clean Clean", 100));
         * insertSorted(new Barang(7, "So Clean So Clean", 100));
         * insertSorted(new Barang(10, "Clean So So", 30));
         * insertSorted(new Barang(9, "So Clean Clean", 20));
         * insertSorted(new Barang(4, "Clean So", 10));
         */
        printList();
        delete(4);
        delete(1);
        delete(10);
        delete(99);
        printList();
    }
}
