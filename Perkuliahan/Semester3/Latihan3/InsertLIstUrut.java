package Perkuliahan.Semester3.Latihan3;

// Kelas Node untuk membentuk struktur dari Linked List
class Node2 {
    int data;
    Node next;

    // Konstruktor untuk Node
    Node2(int d) {
        data = d;
        next = null;
    }
}

public class InsertLIstUrut {
    Node head; // Head dari list

    // Metode untuk menyisipkan node secara terurut (dari kecil ke besar)
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
        insertSorted(11); // Urutan penyisipan 5
        insertSorted(9);  // Urutan penyisipan 2
        insertSorted(5);  // Urutan penyisipan 1
        insertSorted(12); // Urutan penyisipan 3
        insertSorted(22); // Urutan penyisipan 4
        delete(22);       // Hapus elemen 22
        printList();      // Cetak sesuai urutan linked list (terurut dari kecil ke besar)
    }
}
