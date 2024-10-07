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

public class Cari {
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

    // fungsi deleting
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

    // fungsi searching
    public void searchData(int data) {
        Node current = head;
        int posisi = 1; // Urutan posisi dimulai dari 1 ya

        // Lakukan pencarian datanya di dalam list
        while (current != null) {
            if (current.data == data) {
                System.out.println("Data " + data + " ditemukan pada urutan ke-" + posisi);
                System.out.println();
                return;
            }
            current = current.next;
            posisi++;
        }

        // Jika data tidak ditemukan
        System.out.println("Data " + data + " tidak ditemukan\n");
    }

    //fungsi print ya teman
    public void printList() {
        Node current = head;
        System.out.print("Single LinkedList : ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Cari sll = new Cari();
        sll.runThis();
    }

    // Metode untuk menjalankan contoh pengisian data
    void runThis() {
        insertSorted(11);
        insertSorted(9);
        insertSorted(5);
        insertSorted(12);
        insertSorted(22);
        delete(22);
        delete(5);
        System.out.println();
        printList();

        // Contoh pencarian data
        searchData(11); 
        searchData(90); 
        searchData(95); 
    }
}
