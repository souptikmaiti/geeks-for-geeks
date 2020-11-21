import java.util.HashMap;

public class _84_MergeSort {

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

    public static void main(String args[]) {

        Node head1 = createList(5 , 22 , 3 , 10, 7, 7, 7, 7, 7, 12, 9);
        Node head2 = createList(3 , 4 , 8 , 10);

        System.out.println("First");
        printList(head1);
        printList(mergeSort(head1));
        System.out.println("Second");
        printList(head2);
        printList(mergeSort(head2));
    }

    static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node mid = getMiddle(head);
        Node afterMid = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(afterMid);

        return mergeTwoSortedLists(left, right);
    }

    static Node getMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node mergeTwoSortedLists(Node h1, Node h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        Node result = null;
        if (h1.data <= h2.data) {
            result = h1;
            result.next = mergeTwoSortedLists(h1.next, h2);
        } else {
            result = h2;
            result.next = mergeTwoSortedLists(h1, h2.next);
        }
        return result;
    }
}
