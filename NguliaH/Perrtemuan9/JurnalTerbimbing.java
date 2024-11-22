package NguliaH.Perrtemuan9;

import java.util.Scanner;

public class JurnalTerbimbing {

    Node root;

    public static void main(String[] args) {
        JurnalTerbimbing tree = new JurnalTerbimbing();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah elemen yang ingin ditambahkan: ");
        int n = scanner.nextInt();

        System.out.println("Masukkan " + n + " nilai : ");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        tree.dataShow();

        scanner.close();
    }

    public JurnalTerbimbing() {
        root = null;
    }

    //niki insert
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

    //tampilkan data
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

    //method 

    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
