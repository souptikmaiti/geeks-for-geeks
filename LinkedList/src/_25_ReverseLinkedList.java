public class _25_ReverseLinkedList {
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
        //printList(reverseList(head));
        //printList(recursiveReverse(head));
        printList(reverseUtil(head, null));
    }

    private static Node reverseList(Node head) {
        Node before = null;
        Node current = head;
        Node after;

        while(current != null) {
            after = current.next;
            current.next = before;


            before = current;
            current = after;
        }
        return before;
    }

    static Node recursiveReverse(Node head)
    {
        if (head == null || head.next == null)
            return head;

        Node rest = recursiveReverse(head.next);  // draw a stack diagram to understand. res acts as new head of reversed list

        //the following 2 steps reverse the existing pointer direction between first 2 elements and deletes the original pointer
        head.next.next = head;
        head.next = null;

        /* fix the head pointer */
        return rest;
    }

    static Node reverseUtil(Node curr, Node prev){

        if(curr.next == null){
            curr.next = prev;
            return curr; // new head
        }

        Node after = curr.next;
        curr.next = prev;
        return reverseUtil(after, curr);
    }
}
