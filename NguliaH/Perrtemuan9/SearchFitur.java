package NguliaH.Perrtemuan9;

import java.util.Scanner;

public class SearchFitur {

    Node root;  

    public static void main(String[] args) {
        SearchFitur tree = new SearchFitur();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah elemen yang ingin dit ambahkan : ");
        int n = scanner.nextInt();

        System.out.print("Masukkan " + n + " nilai : ");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        tree.dataShow();

        //inputan untuk search nya 
        System.out.print("\nMasukkan nilai yang ingin dicari : ");
        int searchValue = scanner.nextInt();
        boolean dicari = tree.search(searchValue);

        if (dicari) {
            System.out.println("\nNilai " + searchValue + " ditemukan dalam tree.");
        } else {
            System.out.println("Nilai " + searchValue + " tidak ditemukan dalam tree." + "\n");
        }

        scanner.close();
    }

    public SearchFitur() {
        root = null;
    }

    public void insert(int data) {
        root = insertRecord(root, data);
    }

    private Node insertRecord(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRecord(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecord(root.right, data);
        }
        return root;
    }

    public void dataShow() {
        System.out.print("Inorder : ");
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
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    void preorderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    void postorderTraversal(Node node) {
        if (node == null)
            return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        if (data < root.data)
            return searchRec(root.left, data);
        else
            return searchRec(root.right, data);
    }

    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
