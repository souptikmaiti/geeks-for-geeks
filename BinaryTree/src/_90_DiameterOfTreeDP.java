import java.util.LinkedList;
import java.util.Queue;

// Diameter of tree = maximum distance between 2 leaf nodes.. it may/ may not pass through root
public class _90_DiameterOfTreeDP {

    static int result = 0;

    static void inorderPrinting(Node tree) {
        if (tree == null)
            return;

        inorderPrinting(tree.left);
        System.out.print(tree.data + " ");
        inorderPrinting(tree.right);
    }

    public static void main(String[] args) {
        /*
         *          1
         *         / \
         *        2   3
         *       / \
         *      4   5
         *     /   / \
         *    10  6   7
         *   /         \
         *  9           8
         *
         * ans 9-10-4-2-5-7-8 : 7
         * */
        Node root = new Node(1);
        root.left= new Node(2);
        root.right= new Node(3);

        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.left.left.left = new Node(10);
        root.left.left.left.left = new Node(9);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.left.right.right.right = new Node(8);

        int j = getDiameter(root);
        System.out.println(result);
    }

    public static int getDiameter(Node root) {
        // Base Condition
        if (root == null)
            return 0;

        // Hypothesis
        int leftHeight = getDiameter(root.left);
        int rightHeight = getDiameter(root.right);

        // Induction
        int excludeMe = 1 + Math.max(leftHeight, rightHeight);
        int includeMe = 1 + leftHeight + rightHeight;
        result = Math.max(result, includeMe);

        return excludeMe; // Pass the temporary result to my parent node
    }

}
