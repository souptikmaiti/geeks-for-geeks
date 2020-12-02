public class _89_MergeKSortedListsIteration {

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
        int k = 3;
        Node[] nodes = new Node[k];
        nodes[0] = createList(1,3,5,7);
        nodes[1] = createList(2,4,6,8);
        nodes[2] = createList(0,9,10,11);

        System.out.println("Original Lists");
        printList(nodes[0]);
        printList(nodes[1]);
        printList(nodes[2]);
        System.out.println("After Merge");
        printList(mergeKListsUsingIteration(nodes));
    }

    static Node mergeKListsUsingIteration(Node[] nodes) {
        int len = nodes.length;
        if (len == 1)
            return nodes[0];

        for (int i = 1; i<len; i++) {
            nodes[0] = mergeTwoLists(nodes[0], nodes[i]);
        }
        return nodes[0];
    }

    static Node mergeTwoLists(Node head1, Node head2) {
        Node result = null, tail = null;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                if (result == null) {
                    result = tail = head1;
                } else {
                    tail.next = head1;
                    tail = tail.next;
                }
                head1 = head1.next;

            } else {
                if (result == null) {
                    result = tail = head2;
                } else {
                    tail.next = head2;
                    tail = tail.next;
                }
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
        }
        while (head2 != null) {
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }
        return result;
    }
}
