public class _91_MergeTwoSortedLists {

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

        Node head1 = createList(3, 3, 3, 3, 5, 7, 7, 9, 10, 22, 22, 22, 22, 28, 28, 28);
        Node head2 = createList(3, 3, 3, 4, 5, 7, 7, 7, 7, 8, 8, 10, 10, 50);

        System.out.println("Two Lists");
        printList(head1);
        printList(head2);
        System.out.println("After Merge");
        printList(mergeLists(head1, head2));
    }

    static Node mergeLists(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node result;
        if (head1.data <= head2.data) {
            result = head1;
            result.next = mergeLists(head1.next, head2);
        } else {
            result = head2;
            result.next = mergeLists(head1, head2.next);
        }
        return result;
    }
}
