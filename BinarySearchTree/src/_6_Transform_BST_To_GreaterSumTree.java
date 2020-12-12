public class _6_Transform_BST_To_GreaterSumTree {

    static void inorderPrint(Node root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    static int sum = 0;
    public static void main(String[] args) {
        Node root = new Node(11);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(7);

        root.right = new Node(29);
        root.right.left = new Node(15);
        root.right.right = new Node(40);
        root.right.right.left = new Node(35);

        inorderPrint(root);
        convert(root);
        System.out.println();
        inorderPrint(root);
    }

    static void convert(Node r) {
        if (r == null) return;
        convert(r.right);
        sum += r.data;
        r.data = sum - r.data;
        convert(r.left);
    }
}
