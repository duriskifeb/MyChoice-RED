package NguliaH.Praktik5;

public class TugasMandiri {

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

        public String getNama() {
            return nama;
        }

        public int getStok() {
            return stok;
        }

        public void setStok(int stok) {
            this.stok = stok;
        }

        public String info() {
            return id + " " + nama + " " + stok;
        }
    }

    class Node {
        Barang data;
        Node next;
        Node prev; // Menambahkan pointer untuk prev

        Node(Barang b) {
            data = b;
            next = null;
            prev = null; // Inisialisasi prev ke null
        }
    }

    Node head; // Kepala dari linked list
    Node tail; // Ekor dari linked list

    // Method untuk memasukkan node di akhir
    public void insert(Barang data) {
        Node nn = new Node(data); // Buat node baru
        if (tail == null) { // Jika list kosong
            head = tail = nn;
        } else {
            tail.next = nn; // Set next dari tail ke node baru
            nn.prev = tail; // Set prev dari node baru ke tail
            tail = nn; // Update tail menjadi node baru
        }

        System.out.println("Node baru " + data.info() + " ditambahkan di akhir list");
    }

    // Method untuk memasukkan node secara terurut (ascending) berdasarkan id
    public void insertSorted(Barang data) {
        Node nn = new Node(data); // Buat node baru

        // Kasus jika list kosong atau node baru menjadi yang pertama
        if (head == null || head.data.getId() > nn.data.getId()) {
            nn.next = head; // Set next ke head yang sebelumnya
            if (head != null) {
                head.prev = nn; // Set prev head ke node baru
            }
            head = nn; // Update head menjadi node baru
            if (tail == null) { // Jika list sebelumnya kosong
                tail = nn; // Set tail juga menjadi node baru
            }
        } else {
            Node current = head;
            while (current.next != null && current.next.data.getId() < nn.data.getId()) {
                current = current.next;
            }
            nn.next = current.next; // Set next node baru

            if (current.next != null) { // Jika bukan di akhir list
                current.next.prev = nn; // Set prev dari node berikutnya
            } else {
                tail = nn; // Update tail jika menambah ke akhir
            }
            current.next = nn; // Update next current menjadi node baru
            nn.prev = current; // Set prev node baru ke current
        }

        System.out.println("Node baru " + data.info() + " ditambahkan secara terurut");
    }

    // Method untuk menghapus node berdasarkan id
    public void delete(int id) {
        if (head == null) {
            System.out.println("List kosong");
            return;
        }

        // Jika node yang dihapus adalah head
        if (head.data.getId() == id) {
            head = head.next;
            if (head != null) {
                head.prev = null; // Update prev head
            } else {
                tail = null; // Jika list menjadi kosong
            }
            System.out.println("Node " + id + " telah dihapus");
            return;
        }

        // Mencari node untuk dihapus
        Node current = head;

        while (current != null) {
            if (current.data.getId() == id) {
                if (current.next != null) {
                    current.next.prev = current.prev; // Bypass node yang dihapus
                }
                if (current.prev != null) {
                    current.prev.next = current.next; // Bypass node yang dihapus
                } else {
                    head = current.next; // Update head jika perlu
                }
                System.out.println("Node " + id + " telah dihapus");
                return;
            }
            current = current.next;
        }

        // Jika node tidak ditemukan
        System.out.println("Node " + id + " tidak ditemukan");
    }

    // Method untuk mencari barang berdasarkan nama dan stok
    public void searchByNameAndStock(String nama, int stok) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.data.getNama().equalsIgnoreCase(nama) && current.data.getStok() == stok) {
                System.out.println("Data ditemukan : " + current.data.info());
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("\nData dengan nama '" + nama + "' dan stok '" + stok + "' tidak ditemukan");
        }
    }

    // Method untuk memperbarui stok
    public void updateStock(int id, int newStock) {
        Node current = head;

        while (current != null) {
            if (current.data.getId() == id) {
                current.data.setStok(newStock);
                System.out.println("Jumlah stok untuk barang ID " + id + " telah diperbarui menjadi: " + newStock);
                return;
            }
            current = current.next;
        }

        System.out.println("Barang dengan ID " + id + " tidak ditemukan");
    }

    // Method untuk mencetak list
    public void printList() {
        Node current = head;
        System.out.print("Double Linked List: ");
        while (current != null) {
            System.out.print(current.data.info() + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method untuk menjalankan program
    public static void main(String[] args) {
        TugasMandiri dll = new TugasMandiri();
        dll.runThis();
    }

    // Method untuk menjalankan contoh data
    void runThis() {
        System.out.println("================================================");

        // Insert items not sorted
        insert(new Barang(5, "Clean", 55));
        insert(new Barang(2, "Supeno", 11));
        insert(new Barang(1, "Zaidun Qoim", 21));

        System.out.println("================================================");

        // Insert items sorted
        insertSorted(new Barang(8, "one", 88));
        insertSorted(new Barang(3, "two", 33));
        insertSorted(new Barang(6, "three", 66));
        insertSorted(new Barang(7, "four", 77));
        insertSorted(new Barang(10, "five", 100));
        insertSorted(new Barang(9, "six", 99));
        insertSorted(new Barang(4, "seven", 44));

        System.out.println("================================================");
        printList();
        System.out.println();

        // Deleting elements
        System.out.println("Penghapusan Data : ");
        delete(4);
        delete(1);
        delete(10);
        delete(99);

        printList();
        System.out.println("================================================");

        // Searching by name and stock
        System.out.println("\nPencarian Data : ");
        searchByNameAndStock("Clean", 55);
        searchByNameAndStock("Supeno", 11);
        searchByNameAndStock("Zaidun Qoim", 21);

        System.out.println("================================================\n");

        // Updating stock
        System.out.println("Update Data : ");
        updateStock(5, 60);
        updateStock(10, 120);
        System.out.println("================================================");
        printList();
    }
}
