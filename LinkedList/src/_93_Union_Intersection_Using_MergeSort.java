public class _93_Union_Intersection_Using_MergeSort {

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

    static Node pushNode(Node head, Node node) {
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
        Node head2 = createList(3, 3, 3, 4, 7, 7, 7, 7, 8, 10);

        System.out.println("After Sort");
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        printList(head1);
        printList(head2);
        System.out.println("Union");
        printList(getUnion(head1, head2, null)); // head1 and head2 got modified so create fresh lists to call intersection

        Node head3 = createList(5, 22, 3, 3, 3, 3, 10, 7, 7, 9, 28, 28, 28, 22, 22, 22);
        Node head4 = createList(3, 3, 3, 4, 7, 7, 7, 7, 8, 10);
        head3 = mergeSort(head3);
        head4 = mergeSort(head4);
        System.out.println("Intersection");
        printList(getIntersection(head3, head4, null));
    }

    static Node getUnion(Node head1, Node head2, Node before) {
        if (head1 == null && head2 == null)
            return null;
        Node result = null;
        if (head1 == null) {
            if (before != null && before.data == head2.data)
                return getUnion(null, head2.next, before);
            result = before = head2;
            result.next = getUnion(null, head2.next, before);
        }
        if (head2 == null) {
            if (before != null && before.data == head1.data)
                return getUnion(head1.next, null, before);
            result = before = head1;
            result.next = getUnion(head1.next, null, before);

        }
        if (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (before != null && before.data == head1.data)
                    return getUnion(head1.next, head2, before);
                result = before = head1;
                result.next = getUnion(head1.next, head2, before);
            } else if (head2.data < head1.data) {
                if (before != null && before.data == head2.data)
                    return getUnion(head1, head2.next, before);
                result = before = head2;
                result.next = getUnion(head1, head2.next, before);
            } else {
                if (before != null && before.data == head2.data)
                    return getUnion(head1.next, head2.next, before);
                result = before = head2;
                result.next = getUnion(head1.next, head2.next, before);
            }
        }
        return result;
    }

    static Node getIntersection(Node head1, Node head2, Node before) {
        if (head1 == null || head2 == null)
            return null;

        Node result = null;
        if (head1.data < head2.data)
            return getIntersection(head1.next, head2, before);
        else if (head2.data < head1.data)
            return getIntersection(head1, head2.next, before);
        else {
            if (before != null && before.data == head1.data)
                return getIntersection(head1.next, head2.next, before);
            result = before = head1;
            result.next = getIntersection(head1.next, head2.next, before);
        }
        return result;
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
