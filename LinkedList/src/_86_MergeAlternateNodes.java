public class _86_MergeAlternateNodes {

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

    static void addNode(Node n, int data) {
        Node newNode = new Node(data);
        Node t = n;
        while(t.next != null)
            t = t.next;
        t.next = newNode;
    }

    public static void main(String[] args) {

        Node head1 = createList(5, 7, 17, 13, 11);
        Node head2 = createList(12, 10, 2, 4, 6);

        printList(head1);
        printList(head2);
        System.out.println("First");
        Node[] nodes = mergeAlternate(head1, head2);
        printList(nodes[0]);
        System.out.println("Second");
        printList(nodes[1]);
    }

    static Node[] mergeAlternate(Node head1, Node head2) {
        Node[] nodes = new Node[2];
        Node res1 = null, tail1 = null, res2 = null, tail2 = null;
        boolean flag = true;
        while (head1 != null && head2 != null) {
            if (flag) {
                if (res1 == null) {
                    res1 = tail1 = head1;
                } else {
                    tail1.next = head1;
                    tail1 = tail1.next;
                }
                head1 = head1.next;
            } else {
                tail1.next = head2;
                tail1 = tail1.next;
                head2 = head2.next;
            }
            flag = !flag;
        }

        while (head1 != null) {
            if (res2 == null) {
                res2 = tail2 = head1;
            } else {
                tail2.next = head1;
                tail2 = tail2.next;
            }
            head1 = head1.next;
        }
        while (head2 != null) {
            if (res2 == null) {
                res2 = tail2 = head2;
            } else {
                tail2.next = head2;
                tail2 = tail2.next;
            }
            head2 = head2.next;
        }
        nodes[0] = res1;
        nodes[1] = res2;
        return nodes;
    }
}
