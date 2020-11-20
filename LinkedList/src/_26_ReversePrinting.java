public class _26_ReversePrinting {
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
        Node head = new Node(1);
        addNode(head, 2);
        addNode(head, 3);
        addNode(head, 4);
        addNode(head, 5);
        addNode(head, 6);
        addNode(head, 7);
        addNode(head, 8);

        System.out.println("Origional Linked List");
        printList(head);
        System.out.println("Modified Linked List");
        reversePrint(head);
    }

    static void reversePrint(Node curr){
        if(curr == null)
            return;
        reversePrint(curr.next);
        System.out.print(curr.data + " ");
    }
}
