package NguliaH.Perrtemuan9;

import java.util.Scanner;

class Node {
    Mahasiswa mahasiswa;
    Node left, right;

    public Node(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
        left = right = null;
    }
}

class Mahasiswa {
    int nim;
    String nama;

    public Mahasiswa(int nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public int getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String toString() {
        return (nim + " " + nama);
    }
}

public class Terbimbing3 {

    Node root;

    public static void main(String[] args) {
        Terbimbing3 tree = new Terbimbing3();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah elemen yang ingin ditambahkan : ");
        int n = scanner.nextInt();

        System.out.println("\nMasukkan data mahasiswa [Nim + Nama] :");
        for (int i = 0; i < n; i++) {
            int nim = scanner.nextInt();
            String nama = scanner.next();
            Mahasiswa mahasiswa = new Mahasiswa(nim, nama);
            tree.insert(mahasiswa);
        }

        tree.dataShow();

        System.out.println("\nData mahasiswa dengan NIM terkecil:");
        Mahasiswa minMahasiswa = tree.findMin();
        if (minMahasiswa != null) {
            System.out.println(minMahasiswa);
        } else {
            System.out.println("Tree kosong.");
        }

        System.out.print("\nMasukkan NIM yang ingin dicari : ");
        int searchNim = scanner.nextInt();
        Mahasiswa foundMahasiswa = tree.searchByNim(searchNim);

        if (foundMahasiswa != null) {
            System.out.println("\nMahasiswa ditemukan : " + foundMahasiswa + "\n");
        } else {
            System.out.println("\nMahasiswa dengan NIM : " + searchNim + " maaf tidak ditemukan!" + "\n");
        }

        scanner.close();
    }

    public Terbimbing3() {
        root = null;
    }

    public void insert(Mahasiswa mahasiswa) {
        root = insertRecord(root, mahasiswa);
    }

    private Node insertRecord(Node root, Mahasiswa mahasiswa) {
        if (root == null) {
            root = new Node(mahasiswa);
            return root;
        }

        if (mahasiswa.getNim() < root.mahasiswa.getNim()) {
            root.left = insertRecord(root.left, mahasiswa);
        } else if (mahasiswa.getNim() > root.mahasiswa.getNim()) {
            root.right = insertRecord(root.right, mahasiswa);
        }
        return root;
    }

    public void dataShow() {
        System.out.print("\nInorder : ");
        inorderRec(root);
        System.out.println();
        System.out.print("Preorder : ");
        preorderTraversal(root);
        System.out.println();
        System.out.print("Postorder : ");
        postorderTraversal(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.mahasiswa + " ");
            inorderRec(root.right);
        }
    }

    void preorderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.mahasiswa + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    void postorderTraversal(Node node) {
        if (node == null)
            return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.mahasiswa + " ");
    }

    public Mahasiswa findMin() {
        if (root == null) {
            return null;
        }
        return findMinRec(root).mahasiswa;
    }

    private Node findMinRec(Node root) {
        if (root.left == null) {
            return root;
        }
        return findMinRec(root.left);
    }

    public Mahasiswa searchByNim(int nim) {
        Node result = searchByNimRec(root, nim);
        return (result != null) ? result.mahasiswa : null;
    }

    private Node searchByNimRec(Node root, int nim) {
        if (root == null || root.mahasiswa.getNim() == nim) {
            return root;
        }
        if (nim < root.mahasiswa.getNim()) {
            return searchByNimRec(root.left, nim);
        }
        return searchByNimRec(root.right, nim);
    }
}
