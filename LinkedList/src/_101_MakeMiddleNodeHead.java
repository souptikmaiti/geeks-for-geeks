public class _101_MakeMiddleNodeHead {
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

    public static void main(String[] args) {

        Node head1 = createList(1, 2, 3, 4, 5);
        Node head2 = createList(1, 2, 3, 4, 5, 6);

        System.out.println("Original Linked List");
        printList(head2);
        printList(makeMiddleHead(head2));
    }

    static Node makeMiddleHead(Node head) {
        Node fast = head, slow = head, midBef = null;

        while (fast != null && fast.next != null) {
            midBef = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(midBef != null) {
            midBef.next = slow.next;
            slow.next = head;
            head = slow;
        }
        return head;
    }

}
