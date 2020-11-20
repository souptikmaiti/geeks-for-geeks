public class _41_FlatenModifiedList {
    static class ModifiedNode {
        int data;
        ModifiedNode right;
        ModifiedNode down;

        public ModifiedNode(int data) {
            this.data = data;
            this.right = null;
            this.down = null;
        }
    }
    static ModifiedNode push(ModifiedNode head, int data) {
        ModifiedNode newNode = new ModifiedNode(data);
        newNode.down = head;
        head = newNode;
        return head;
    }

    static void printList(ModifiedNode n) {
        while(n != null)
        {
            System.out.print(n.data+" ");
            n = n.down;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */


        ModifiedNode head = push(null, 30);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 5);

        head.right = push(head.right, 20);
        head.right = push(head.right, 10);

        head.right.right = push(head.right.right, 50);
        head.right.right = push(head.right.right, 22);
        head.right.right = push(head.right.right, 19);

        head.right.right.right = push(head.right.right.right, 45);
        head.right.right.right = push(head.right.right.right, 40);
        head.right.right.right = push(head.right.right.right, 35);
        head.right.right.right = push(head.right.right.right, 28);

        printList(flatten(head));

    }

    public static ModifiedNode merge(ModifiedNode node1, ModifiedNode node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        ModifiedNode result;
        if(node1.data < node2.data){
            result = node1;
            result.down = merge(node1.down, node2);
        }else {
            result = node2;
            result.down = merge(node1, node2.down);
        }
        result.right = null;
        return result;
    }

    public static ModifiedNode flatten(ModifiedNode root) {
        if(root == null || root.right == null)
            return root;

        root.right = flatten(root.right);
        root = merge(root, root.right);
        return root;
    }
}
