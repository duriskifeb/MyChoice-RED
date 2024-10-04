package Perkuliahan.Semester3.Latihan3;


// Kelas Node untuk membentuk struktur dari Linked List
class Node3 {
    int data;
    Node next;

    // Konstruktor untuk Node
    Node3(int d) {
        data = d;
        next = null;
    }
}

public class DeleteTampilkan {
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
            System.out.println("Node baru " + data + " ditambahkan secara terurut");
        }
        System.out.println();
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
        System.out.println("Node " + data + " tidak ditemukan, karena tidak di list :( ");
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
        DeleteTampilkan sll = new DeleteTampilkan();
        sll.runThis();
    }

    // Metode untuk menjalankan contoh pengisian data dan penghapusan
    void runThis() {
        // Menggunakan insertSorted untuk memasukkan data secara urut
        insertSorted(5);
        insertSorted(9);
        insertSorted(12);
        insertSorted(22);
        insertSorted(11);
        printList(); // Cetak list awal

        // Hapus nilai 5
        delete(5);
        printList(); // Cetak setelah penghapusan 5
        // Hapus nilai 5
        delete(11);
        printList(); // Cetak setelah penghapusan 5
        // Hapus nilai 5
        delete(22);
        printList(); // Cetak setelah penghapusan 5

        // Hapus nilai 1 (tidak ada dalam list)
        delete(1);
        System.out.println();
    }
}
