package NguliaH.Praktik4;


class Node {
    int data;
    Node next;

    // Konstruktor untuk Node
    Node(int d) {
        data = d;
        next = null;
    }
}

public class InsertList {

    // Kelas pertama InsertUrut
    public static class InsertSesuaiPrint {
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

        public void printList() {
            Node current = head;
            System.out.print("Single LinkedList (InsertUrut): ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        // Metode untuk menjalankan contoh pengisian data
        void runThis() {
            insert(2);
            insert(5);
            insert(8);
            insert(99);
            insert(21);
            delete(22);
            printList();
        }
    }

    // Kelas kedua InsertLIstUrut
    public static class InsertLIstUrut {
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
            System.out.print("Single LinkedList (InsertLIstUrut): ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        // Metode untuk menjalankan contoh pengisian data
        void runThis() {
            insertSorted(11);
            insertSorted(9);
            insertSorted(5);
            insertSorted(12);
            insertSorted(22);
            delete(22);
            printList();
        }
    }

    // Metode utama untuk menjalankan program
    public static void main(String[] args) {
        // Jalankan InsertUrut
        System.out.println("=== InsertSesuaiPrint ===");
        InsertSesuaiPrint sll1 = new InsertSesuaiPrint();
        sll1.runThis();

        // Jalankan InsertLIstUrut
        System.out.println("\n=== InsertLIstUrut ===");
        InsertLIstUrut sll2 = new InsertLIstUrut();
        sll2.runThis();
        System.out.println();
    }
}
