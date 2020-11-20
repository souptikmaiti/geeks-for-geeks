public class _98_InsertAfterNthFromEnd {
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

    public static void main(String args[]) {

        Node head = createList(10, 8, 3, 12, 5, 18);
        Node head2 = createList(1, 3, 4, 5);

        System.out.println("First Linked List");
        printList(head);
        insertAfterNthFromEnd(head, 2, -99);
        printList(head);
        System.out.println("Second Linked List");
        printList(head2);
        insertAfterNthFromEnd(head2, 4, -99);
        printList(head2);
    }

    static void insertAfterNthFromEnd(Node head, int n, int data) {
        Node newNode = new Node(data);
        Node slow = head, fast = head;
        int i = 1;
        while (fast.next != null) {
            i ++;
            fast = fast.next;
            if (i > n) {
                slow = slow.next;
            }
        }
        Node after = slow.next;
        slow.next = newNode;
        newNode.next = after;
    }

}
