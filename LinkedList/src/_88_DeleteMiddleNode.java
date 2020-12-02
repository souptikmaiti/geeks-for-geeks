import java.util.Comparator;
import java.util.PriorityQueue;

public class _88_DeleteMiddleNode {

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
        Node head1 = createList(1, 2, 3, 4, 5); // output = 1, 2, 4, 5
        Node head2 = createList(1, 2, 3, 4, 5, 6); //output = 1, 2, 3, 5, 6 delete 2nd middle

        printList(head1);
        deleteMiddleNode(head1);
        printList(head1);
        printList(head2);
        deleteMiddleNode(head2);
        printList(head2);
    }

    static void deleteMiddleNode(Node head) {
        if (head == null || head.next == null)
            return;

        Node slow = head, befSlow = null, fast = head;

        while (fast != null && fast.next != null) {
            befSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (befSlow != null)
            befSlow.next = slow.next;
    }
}
