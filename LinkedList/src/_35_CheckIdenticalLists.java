public class _35_CheckIdenticalLists {
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

    public static void main(String args[])
    {
        Node head1 = new Node(1);
        addNode(head1, 2);
        addNode(head1, 3);
        addNode(head1, 4);
        addNode(head1, 5);

        Node head2 = new Node(1);
        addNode(head2, 2);
        addNode(head2, 3);
        addNode(head2, 4);
        addNode(head2, 5);



        System.out.println("Original Linked Lists");
        printList(head1);
        printList(head2);

        System.out.println(checkIdenticalRecur(head1, head2));
    }

    private static boolean checkIdentical(Node head1, Node head2){
       while(head1 != null && head2 != null){
           if(head1.data != head2.data)
               return false;
           head1 = head1.next;
           head2 = head2.next;
       }
        return head1 == null && head2 == null;
    }

    private static boolean checkIdenticalRecur(Node head1, Node head2){
        if(head1 == null && head2 == null )
            return true;
        if(head1 == null || head2 == null)
            return false;

        if(head1.data == head2.data)
            return checkIdenticalRecur(head1.next, head2.next);
        return false;
    }
}
