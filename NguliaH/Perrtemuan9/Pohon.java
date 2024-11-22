package NguliaH.Perrtemuan9;

public class Pohon {
    Node root;

    public static void main(String[] args) {
        JurnalTerbimbing tree = new JurnalTerbimbing();

        tree.dataShow();
    }

    public Pohon() {
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
        if (data < root.data)
            root.left = insertRecord(root.left, data);
        else if (data > root.data)
            root.right = insertRecord(root.right, data);
        return root;
    }

    public void dataShow() {
        System.out.print("inorder  : ");
        inorderRec(root);
        System.out.print("Preorder : ");
        preorderTraversal(root);
        System.out.print("Postorder : ");
        postorderTraversal(root);
    }

    /*
     * Inorder traversal
     * a. Traverse the left subtree
     * b. Visit the root.
     * c. Traverse the right subtree
     */
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    /*
     * Preorder traversal
     * a. Visit the root.
     * b. Traverse the left subtree
     * c. Traverse the right subtree
     */
    void preorderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /*
     * Postorder traversal
     * a. Traverse the left subtree
     * b. Traverse the right subtree
     * c. Visit the root.
     */
    void postorderTraversal(Node node) {
        if (node == null)
            return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    // Node Class
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
