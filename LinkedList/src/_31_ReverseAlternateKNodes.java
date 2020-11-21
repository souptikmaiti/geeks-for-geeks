import java.util.Stack;

public class _31_ReverseAlternateKNodes {
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
        addNode(head, 11);


        System.out.println("Original Linked Lists");
        printList(head);
        System.out.println("After Group Reverse");
        printList(reverseAlternate(head, 3));

    }

    private static Node reverseAlternate(Node head, int group){
        Node current = head;
        Node after = null, before = null;

        int count = 0;
        while (count < group && current != null) {
            count ++;
            after = current.next;
            current.next = before;

            before = current;
            current = after;
        }
        if(head != null)
            head.next = current;

        int j = 1;
        while (j<group && current != null){
            j++;
            current = current.next;
        }

        if(current != null && current.next != null)
            current.next = reverseAlternate(current.next, group);

        return before;
    }
}
