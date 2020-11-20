public class _33_DeleteAlternateNodes {
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
        addNode(head, 9);
        addNode(head, 10);
        //addNode(head, 11);


        System.out.println("Original Linked Lists");
        printList(head);
        System.out.println("After Alternative delete");
        deleteAlternateRecur(head);
        printList(head);
    }

    private static void deleteAlternate(Node head){
        Node current = head;
        Node after;
        while (current != null) {
            after = current.next;
            if(after != null) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    private static void deleteAlternateRecur(Node current){
        if(current == null)
            return;

        Node after = current.next;
        if(after != null) {
            current.next = current.next.next;
        }
        deleteAlternateRecur(current.next);
    }
}
