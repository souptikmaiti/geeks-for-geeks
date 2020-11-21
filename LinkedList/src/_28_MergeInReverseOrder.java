public class _28_MergeInReverseOrder {
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
        Node head1 = new Node(5);
        addNode(head1, 10);
        addNode(head1, 15);
        addNode(head1, 40);

        Node head2 = new Node(2);
        addNode(head2, 3);
        addNode(head2, 20);

        System.out.println("Original Linked Lists");
        printList(head1);
        printList(head2);
        System.out.println("After Merge");
        printList(mergeInReverse(head1, head2));

    }

    static Node mergeInReverse(Node head1, Node head2){
        Node newHead = null;
        while (head1 != null || head2 != null ) {
            if(head1 == null) {
                newHead = pushInFront(newHead, head2.data);
                head2 = head2.next;
                continue;
            }

            if(head2 == null) {
                newHead = pushInFront(newHead, head1.data);
                head1 = head1.next;
                continue;
            }

            if(head1.data < head2.data) {
                newHead = pushInFront(newHead, head1.data);
                head1 = head1.next;
            } else if(head2.data < head1.data) {
                newHead = pushInFront(newHead, head2.data);
                head2 = head2.next;
            }else {
                newHead = pushInFront(newHead, head1.data);
                newHead = pushInFront(newHead, head1.data); // if want to keep duplicates
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return newHead;
    }

    static Node pushInFront(Node head, int data) {
        Node n = new Node(data);
        n.next = head;
        return n;
    }
}
