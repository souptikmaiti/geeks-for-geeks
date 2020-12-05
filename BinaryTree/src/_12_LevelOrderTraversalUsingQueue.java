import java.util.LinkedList;
import java.util.Queue;

public class _12_LevelOrderTraversalUsingQueue {

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
        Node root = new Node(13);
        insertNode(root, 12);
        insertNode(root, 10);
        insertNode(root, 4);
        insertNode(root, 19);
        insertNode(root, 16);
        insertNode(root, 9);

        inorderPrinting(root);
        System.out.println("");
        printLevelOrder(root);
    }

    // using queue
    static void printLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node tmp;

        while (!q.isEmpty()) {
            tmp = q.poll();
            System.out.print(tmp.data + " ");
            if (tmp.left != null)
                q.add(tmp.left);
            if (tmp.right != null)
                q.add(tmp.right);
        }
    }
}
