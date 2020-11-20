public class _36_DeleteNodeIfNextIsGreater {
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
        //12->15->10->11->5->6->2->3
        Node head = new Node(12);
        addNode(head, 15);
        addNode(head, 10);
        addNode(head, 11);
        addNode(head, 5);
        addNode(head, 6);
        addNode(head, 2);
        addNode(head, 3);

        //10->20->30->40->50->60
        Node head2 = new Node(10);
        addNode(head2, 20);
        addNode(head2, 30);
        addNode(head2, 40);
        addNode(head2, 50);
        addNode(head2, 60);

        //60->50->40->30->20->10
        Node head3 = new Node(60);
        addNode(head3, 50);
        addNode(head3, 40);
        addNode(head3, 30);
        addNode(head3, 20);
        addNode(head3, 10);

        System.out.println("Original Linked Lists");
        printList(head);
        printList(deleteIfNextGreater(head));
        //System.out.println("After Modification Linked Lists");
        //printList(head);
    }

    private static Node deleteIfNextGreater(Node head){
        Node current = head, before = null, after = null;
        while(current != null && current.next != null){
            after = current.next;
            if(current.data < after.data){
                if(before == null) {
                    head = after;
                    current = head;
                } else {
                    before.next = after;
                    current = before;
                }
            }else {
                before = current;
                current = after;
            }
        }
        return head;
    }
}
