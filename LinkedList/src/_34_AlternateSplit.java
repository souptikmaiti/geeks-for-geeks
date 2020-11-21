public class _34_AlternateSplit {
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

    public static void main(String[] args)
    {
        Node head = new Node(1);
        addNode(head, 2);
        addNode(head, 3);
        addNode(head, 4);
        addNode(head, 5);
        addNode(head, 6);
        addNode(head, 7);
        addNode(head, 8);
        addNode(head, 9);
        addNode(head, 10);
        //addNode(head, 11);


        System.out.println("Original Linked Lists");
        printList(head);
        System.out.println("After Alternative split");
        alternatingSplitList(head);
    }

    private static void alternatingSplitList(Node head){
        if(head == null)
            return;

        Node a, b, aTail, bTail;
        a = aTail = head;
        b = bTail = head.next;
        head = head.next.next;
        while (head != null) {
            aTail = moveNode(aTail, head.data);
            head = head.next;
            if (head != null) {
                bTail = moveNode(bTail, head.data);
                head = head.next;
            }
        }
        printList(a);
        printList(b);
    }

    private static Node moveNode(Node tail, int data) {
        tail.next = new Node(data);
        tail = tail.next;
        return tail;
    }
}
