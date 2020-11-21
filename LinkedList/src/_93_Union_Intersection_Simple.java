public class _93_Union_Intersection_Simple {

    static Node createList(int... data) {
        Node head = new Node(data[0]);
        Node tail = head;
        for (int i = 1; i < data.length; i++) {
            tail.next = new Node(data[i]);
            tail = tail.next;
        }
        return head;
    }

    static void printList(Node n) {
        Node temp = n;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node pushNode(Node head, int data) {
        Node node = new Node(data);
        if (head == null) {
            return node;
        }
        node.next = head;
        head = node;
        return head;
    }

    static void addNode(Node n, int data) {
        Node newNode = new Node(data);
        Node t = n;
        while (t.next != null)
            t = t.next;
        t.next = newNode;
    }

    public static void main(String[] args) {

        Node head1 = createList(5, 22, 3, 3, 3, 3, 10, 7, 7, 9, 28, 28, 28, 22, 22, 22);
        Node head2 = createList(3, 3, 3, 4, 7, 7, 7, 7, 10, 5, 8);

        System.out.println("After Sort");
        printList(head1);
        printList(head2);
        System.out.println("Union");
        printList(getUnion(head1, head2)); // head1 and head2 got modified so create fresh lists to call intersection

        Node head3 = createList(5, 22, 3, 3, 3, 3, 10, 7, 7, 9, 28, 28, 28, 22, 22, 22);
        Node head4 = createList(3, 3, 3, 4, 7, 7, 7, 7, 10, 5, 8);
        System.out.println("Intersection");
        printList(getIntersection(head3, head4));
    }

    static Node getUnion(Node head1, Node head2) {
        Node result = null;
        while (head1 != null) {
            if (!isPresent(result, head1.data)) {
                result = pushNode(result, head1.data);
            }
            head1 = head1.next;
        }
        while (head2 != null) {
            if (!isPresent(result, head2.data)) {
                result = pushNode(result, head2.data);
            }
            head2 = head2.next;
        }
        return result;
    }

    static Node getIntersection(Node head1, Node head2) {
        Node result = null;
        while (head1 != null) {
            if (isPresent(head2, head1.data) && !isPresent(result, head1.data))
                result = pushNode(result, head1.data);
            head1 = head1.next;
        }
        return result;
    }

    static boolean isPresent(Node h, int data) {
        if (h == null)
            return false;
        while (h != null) {
            if (h.data == data)
                return true;
            h = h.next;
        }
        return false;
    }
}
