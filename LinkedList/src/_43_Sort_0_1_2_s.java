public class _43_Sort_0_1_2_s {
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

    static Node pushNode(Node head, Node node) {
        node.next = head;
        head = node;
        return head;
    }

    public static void main(String[] args) {

        //1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> NULL
        Node head = new Node(1);
        addNode(head, 1);
        addNode(head, 2);
        addNode(head, 0);
        addNode(head, 2);
        addNode(head, 0);
        addNode(head, 1);

        //2 1 1 1 0 1 2 0 1 0 1 0 1 2 0 0 1

        Node head2 = new Node(2);
        addNode(head2, 2);
        addNode(head2, 1);
        addNode(head2, 1);
        addNode(head2, 0);
        addNode(head2, 1);
        addNode(head2, 2);
        addNode(head2, 0);

        System.out.println("Original Linked Lists");
        printList(head2);
        printList(sort_0s_1s_2s(head2));
    }

    private static Node sort_0s_1s_2s(Node head) {
        Node tail = head, current = head;
        Node before = null;
        int count = getLength(head);
        while (tail.next != null)
            tail = tail.next;

        while (current != null && count >0) {
            count --;
            if (head.data == 2 && head.next != null) {
                tail.next = head;
                head = head.next;
                current = head;

                tail = tail.next;
                tail.next = null;
                continue;
            }

            before = current;
            current = current.next;
            if (current != null && current.data == 0) {
                before.next = current.next;
                head = pushNode(head, current);
                current = before;
            }

            if (current != null && current.data == 2 && current.next != null) {
                before.next = current.next;
                tail.next = current;
                tail = current;
                tail.next = null;
                current = before;
            }
        }
        return head;
    }

    static int getLength(Node node) {
        int l = 0;
        while (node != null) {
            l++;
            node = node.next;
        }
        return l;
    }

}
