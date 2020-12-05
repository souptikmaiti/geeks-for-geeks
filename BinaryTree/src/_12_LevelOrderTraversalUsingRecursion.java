import java.util.LinkedList;
import java.util.Queue;

public class _12_LevelOrderTraversalUsingRecursion {

    static void inorderPrinting(Node tree) {
        if (tree == null)
            return;

        inorderPrinting(tree.left);
        System.out.print(tree.data + " ");
        inorderPrinting(tree.right);
    }

    static void insertNode(Node root, int data) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node newNode = new Node(data);

        while (! queue.isEmpty()) {
            Node tmp = queue.poll();

            if (tmp.left == null) {
                tmp.left = newNode;
                break;
            } else
                queue.add(tmp.left);

            if (tmp.right == null) {
                tmp.right = newNode;
                break;
            } else
                queue.add(tmp.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left= new Node(2);
        root.right= new Node(3);
        root.right.left= new Node(8);
        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.left.right = new Node(7);
        /*insertNode(root, 12);
        insertNode(root, 10);
        insertNode(root, 4);
        insertNode(root, 19);
        insertNode(root, 16);
        insertNode(root, 9);*/

        inorderPrinting(root);
        System.out.println("");
        System.out.println(getHeight(root));
        printLevelOrder(root, getHeight(root));
    }

    static void printLevelOrder(Node root, int level) {
        for (int i = 1; i<= level; i++)
            printLevelOrderRecursive(root, i);
    }

    static void printLevelOrderRecursive(Node root, int height) {
        if (root == null || height <= 0)
            return;
        if (height == 1)
            System.out.print(root.data + " ");
        printLevelOrderRecursive(root.left, height - 1);
        printLevelOrderRecursive(root.right, height - 1);
    }

    static int getHeight(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftHeight = 1, rightHeight = 1;
        leftHeight += getHeight(root.left);
        rightHeight += getHeight(root.right);
        return Math.max(leftHeight, rightHeight);
    }
}
