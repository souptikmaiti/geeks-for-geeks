public class _24_SegregateEvenOdd {

    static public Node segregate(Node head) {
        if(head == null)
            return null;
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        Node current = head;

        while(current != null) {
            if(current.data % 2 == 0) {
                if(evenStart == null) {
                    evenStart = evenEnd = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            }else {
                if(oddStart == null) {
                    oddStart = oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }

        if(evenStart == null || oddStart == null)
            return null;
        evenEnd.next = oddStart;
        oddEnd.next = null;

        return evenStart;
    }


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
        printList(segregate(head));
        printList(head);
    }
}
