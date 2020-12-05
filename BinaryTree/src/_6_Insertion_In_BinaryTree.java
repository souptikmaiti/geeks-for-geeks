import java.util.LinkedList;
import java.util.Queue;

public class _6_Insertion_In_BinaryTree {

    public static void inorderPrinting(Node tree) {
        if (tree == null)
            return;

        inorderPrinting(tree.left);
        System.out.print(tree.data + " ");
        inorderPrinting(tree.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        insertNode(root, 11);
        insertNode(root, 9);
        insertNode(root, 7);
        insertNode(root, 12);
        insertNode(root, 15);
        insertNode(root, 8);

        inorderPrinting(root);
    }

    public static void insertNode(Node root, int data) {
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
}
