public class _99_RotateBlockWise {
    static Node createList(int ... data) {
        Node head = new Node(data[0]);
        Node tail = head;
        for (int i = 1; i<data.length ; i++) {
            tail.next = new Node(data[i]);
            tail = tail.next;
        }
        return head;
    }

    static void printList(Node n) {
        Node temp = n;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node pushNode(Node head, Node node) {
        node.next = head;
        head = node;
        return head;
    }

    public static void main(String args[]) {

        Node head1 = createList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Node head2 = createList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        System.out.println("Original Linked List");
        printList(head2);
        printList(rotateByBlock(head2, 4, -1));  //2->3->4->1->6->7->8->5->10->11->12->9->14->15->13->NUL
    }

    static Node rotateByBlock(Node pivot, int block, int r) {
        if (pivot == null)
            return null;
        Node curr = pivot;
        Node after = null, tail = null;
        int i = 1;
        while (curr != null && i<block) {
            i++;
            curr = curr.next;
        }
        if (curr != null) {
            after = curr.next;
            curr.next = null;
        }

        //rotate
        Node[] nodes = rotateByK(pivot, r);
        pivot = nodes[0];
        tail = nodes[1];
        tail.next = rotateByBlock(after, block, r);

        return pivot;
    }

    private static Node[] rotateByK(Node head, int r) {
        Node tail = head, before = head, after;
        Node[] nodes = new Node[2];
        while (tail.next != null) {
            tail = tail.next;
        }
        while (r < 0) { // anticlockwise
            r ++;
            after = head.next;
            tail.next = head;
            tail = tail.next;
            tail.next = null;
            head = after;
        }

        while (r >0) {  // clockwise
            r --;
            tail = head;
            while (tail.next != null) {
                before = tail;
                tail = tail.next;
            }
            tail.next = head;
            head = tail;
            before.next = null;
        }
        tail = head;
        while (tail.next != null)
            tail = tail.next;
        nodes[0] = head;
        nodes[1] = tail;
        return nodes;
    }

}
