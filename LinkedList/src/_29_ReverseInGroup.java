public class _29_ReverseInGroup {
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


        System.out.println("Original Linked Lists");
        printList(head);
        System.out.println("After Group Reverse");
        printList(reverseInGroup(head, 3));

    }

    private static Node reverseInGroup(Node head, int group){
        Node current = head;
        Node before = null, after = null;
        int count = 0;
        while(count<group && current != null) {
            count ++;
            after = current.next;
            current.next = before;

            before = current;
            current = after;
        }

        if(after != null) {
            head.next = reverseInGroup(current, group);
        }
        return before;
    }
}
