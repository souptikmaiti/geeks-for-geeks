public class _46_PairwiseSwapByLinks {

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
        System.out.println("Iteration");
        Node head1 = createList(1, 2, 3, 4, 5, 6, 7);
        printList(head1);
        printList(swapPairIteration(head1));

        System.out.println("Recursion");
        Node head2 = createList(1, 2, 3, 4, 5, 6, 7, 8);
        printList(head2);
        printList(swapPairRecursion(head2));
    }

    static Node swapPairIteration(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curr1 = head, before = null, curr2 = head.next, after;
        head = curr2;
        while (curr2 != null) {
           after = curr2.next;
           if (before == null) {
               curr1.next = after;
               curr2.next = curr1;
           } else {
               before.next = curr2;
               curr2.next = curr1;
               curr1.next = after;
           }

           before = curr1;
           curr1 = after;
           if (after != null)
               curr2 = after.next;
           else
               curr2 = null;
        }
        return head;
    }

    static Node swapPairRecursion(Node head) {
        if (head == null || head.next == null)
            return head;

        Node curr = head.next;
        Node after = curr.next;

        curr.next = head;
        head.next = after;
        head = curr;

        head.next.next = swapPairRecursion(after);
        return head;
    }
}
