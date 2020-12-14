// Diameter of tree = maximum distance between 2 leaf nodes.. it may/ may not pass through root
public class _91_MaxPathSumAnyNodeToAnyNode {

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
         *          10
         *         / \
         *        2   10
         *       / \   \
         *      20  1   -25
         *              / \
         *             3   4
         * ans 9-10-4-2-5-7-8 : 7
         * */
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);

        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        int j = maxPathSumAnyNode(root);
        System.out.println(result);
    }

    public static int maxPathSumAnyNode(Node root) {
        // Base Condition
        if (root == null)
            return 0;

        // Hypothesis
        int leftSum = maxPathSumAnyNode(root.left);
        int rightSum = maxPathSumAnyNode(root.right);

        // Induction
        int excludeMe = Math.max(root.data + Math.max(leftSum, rightSum), root.data);  // if both left and right sum are -ve we just consider current val
        int includeMe = root.data + leftSum + rightSum;
        result = Math.max(result, includeMe);

        return excludeMe; // Pass the temporary result to my parent node
    }

}
