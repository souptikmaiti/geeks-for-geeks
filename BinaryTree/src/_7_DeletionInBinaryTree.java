import java.util.LinkedList;
import java.util.Queue;

public class _7_DeletionInBinaryTree {

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
        exchangeDataWithDeepestNodeAndDeleteDeepestNode(root, 19);
        inorderPrinting(root);
    }

    static void exchangeDataWithDeepestNodeAndDeleteDeepestNode(Node root, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node tmp = null, delNode = null, leafParent = null;

        while (!q.isEmpty()) {
            tmp = q.poll();
            if (tmp.data == x)
                delNode = tmp;

            if (tmp.left != null)
                q.add(tmp.left);
            if (tmp.right != null) {
                leafParent = tmp;
                q.add(tmp.right);
            }
        }

        if (delNode != null)
            delNode.data = tmp.data;
        if (leafParent != null)
            leafParent.right = null;
    }
}
