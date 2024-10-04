package Perkuliahan.Semester3.Latihan3;


class Node {
    int data;
    Node next;

    // Konstruktor untuk Node
    Node(int d) {
        data = d;
        next = null;
    }
}

public class InsertUrut {
    Node head; // Head dari list

    // Metode untuk menyisipkan node secara terurut
    public void insertSorted(int data) {
        Node nn = new Node(data); // Membuat node baru
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

    // Metode untuk menyisipkan node di akhir list (tidak terurut)
    public int insert(int data) {
        Node nn = new Node(data);
        Node current = head;

        // Jika list kosong
        if (current == null) {
            nn.next = null;
            head = nn;
        } else {
            // Mencari posisi terakhir
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }
        System.out.println("Node baru " + data + " ditambahkan");
        return 0;
    }

    // Metode untuk mencetak list berdasarkan urutan di dalam linked list
    public void printList() {
        Node current = head;
        System.out.print("Single LinkedList (berdasarkan urutan di dalam list): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Metode utama untuk menjalankan program
    public static void main(String[] args) {
        InsertUrut sll = new InsertUrut();
        sll.runThis();
    }

    // Metode untuk menjalankan contoh pengisian data
    void runThis() {
        // Tambahkan data dan tes metode di sini
        insert(2); // Urutan penyisipan 1
        insert(5); // Urutan penyisipan 2
        insert(8); // Urutan penyisipan 3
        insert(99); // Urutan penyisipan 4
        insert(21); // Urutan penyisipan 5
        delete(22); // Hapus elemen 22
        printList(); // Cetak sesuai urutan linked list
    }
}
