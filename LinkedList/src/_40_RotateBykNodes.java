public class _40_RotateBykNodes {
    static void addNode(Node n, int data) {
        Node newNode = new Node(data);
        Node t = n;
        while(t.next != null)
            t = t.next;
        t.next = newNode;
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

    public static void main(String[] args) {

        //10->20->30->40->50->60
        Node head = new Node(10);
        addNode(head, 20);
        addNode(head, 30);
        addNode(head, 40);
        addNode(head, 50);
        addNode(head, 60);

        //9 8 6 19 12 3 26 18 5
        Node head1 = new Node(9);
        addNode(head1, 8);
        addNode(head1, 6);
        addNode(head1, 19);
        addNode(head1, 12);
        addNode(head1, 3);
        addNode(head1, 26);
        addNode(head1, 18);
        addNode(head1, 5);

        System.out.println("Original Linked Lists");
        printList(head1);
        int k = 4;
        printList(rotateByK(head1, k));
    }

    private static Node rotateByK(Node head, int k) {
        if (k == 0)
            return head;
        int count = 1;
        Node tail = head, current = head;

        while(current != null && count < k) {
            count ++;
            current = current.next;
        }

        if(current == null || current.next == null)
            return head;

        while(tail.next != null) {
            tail = tail.next;
        }
        Node newHead = current.next;
        tail.next = head;
        current.next = null;
        return  newHead;
    }

}
