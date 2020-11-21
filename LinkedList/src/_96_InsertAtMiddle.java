public class _96_InsertAtMiddle {
    static Node createList(int ... data) {
        Node head = new Node(data[0]);
        Node tail = head;
        for (int i = 1; i<data.length ; i++) {
            tail.next = new Node(data[i]);
            tail = tail.next;
        }
        return head;
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

    static Node pushNode(Node head, Node node) {
        node.next = head;
        head = node;
        return head;
    }

    public static void main(String[] args) {

        Node head = createList(1, 2, 4, 5);
        Node head2 = createList(5, 10, 4, 32, 16);

        System.out.println("First Linked List");
        printList(head);
        insertAtMiddle(head, -99);
        printList(head);
        System.out.println("Second Linked List");
        printList(head2);
        insertAtMiddle(head2, -98);
        printList(head2);
    }

    static void insertAtMiddle(Node head, int data) {
        Node newNode = new Node(data);
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node after = slow.next;
        slow.next = newNode;
        newNode.next = after;
    }

}
