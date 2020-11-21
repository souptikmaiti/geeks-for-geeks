public class _95_SelectionSortRecursion {
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

        Node head1 = createList(10 ,  12 ,  8 ,  4 ,  6);
        Node head2 = createList(40, 20, 60, 10, 50, 30);

        System.out.println("First Linked List");
        printList(head1);
        printList(selectionSort(head1));
        System.out.println("Second Linked List");
        printList(head2);
        printList(selectionSort(head2));
    }

    static Node selectionSort(Node head) {
        if (head == null || head.next ==  null)
            return head;

        Node min = head, beforeMin = null, current = head;
        while (current.next != null) {
            if (min.data > current.next.data) {
                beforeMin = current;
                min = current.next;
            }
            current = current.next;
        }
        if (min != head) {
            head = swapNodes(head, beforeMin, min);
        }

        head.next = selectionSort(head.next);
        return head;
    }

    static Node swapNodes(Node x, Node befY, Node y) {
        befY.next = x;
        Node tmp = y.next;
        y.next = x.next;
        x.next = tmp;
        return y;
    }

}
