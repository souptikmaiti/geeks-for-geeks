public class _102_RotateClockwiseAntiClockwise {
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

        Node head = createList(1, 2, 3, 4, 5);
        Node head2 = createList(1, 2, 3, 4, 5, 6);

        System.out.println("Clockwise");
        printList(head);
        printList(rotateByK(head, 3));
        System.out.println("Anticlockwise");
        printList(head2);
        printList(rotateByK(head2, -3));
    }

    private static Node rotateByK(Node head, int k) {
        Node tail = head, before = head, after;
        while (tail.next != null) {
            tail = tail.next;
        }
        while (k < 0) { // anticlockwise
            k ++;
            after = head.next;
            tail.next = head;
            tail = tail.next;
            tail.next = null;
            head = after;
        }
        
        while (k >0) {  // clockwise
            k --;
            tail = head;
            while (tail.next != null) {
                before = tail;
                tail = tail.next;
            }
            tail.next = head;
            head = tail;
            before.next = null;
        }
        return head;
    }

}
