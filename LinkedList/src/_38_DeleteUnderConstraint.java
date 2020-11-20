public class _38_DeleteUnderConstraint {
    static Node addNode(Node n, int data) {
        Node newNode = new Node(data);
        Node t = n;
        while(t.next != null)
            t = t.next;
        t.next = newNode;
        return newNode;
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
        Node head = new Node(5);
        Node n1 = addNode(head, 6);
        Node n2 = addNode(head, 7);
        Node n3 = addNode(head, 8);

        System.out.println("Original Linked Lists");
        printList(head);
        deleteNode(head, head);
        printList(head);
    }

    private static void deleteNode(Node head, Node n) {
        if(head == n){
            head.data = head.next.data;
            head.next = head.next.next;
            System.gc();
            return;
        }
        while (head != null) {
            Node after = head.next;
            if(after == n){
                head.next = after.next;
                System.gc();
                break;
            }
            head = head.next;
        }
    }

}
