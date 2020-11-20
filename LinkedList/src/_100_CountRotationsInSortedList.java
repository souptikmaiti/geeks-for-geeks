public class _100_CountRotationsInSortedList {
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

        Node head = createList(15, 18, 5, 8, 11, 12);

        System.out.println("Original Linked List");
        printList(head);
        System.out.println(countRoatation(head));
    }

    static int countRoatation(Node head) {
        int count = 0;
        int min = head.data;
        while (head != null) {
            if (min > head.data)
                break;
            count++;
            head = head.next;
        }
        return count;
    }

}
