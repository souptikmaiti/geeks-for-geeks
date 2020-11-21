public class _42_Add2LinkedListUsingRecursion {
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

    static Node pushNode(Node head, int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }

    public static void main(String[] args) {

        Node head1 = new Node(3);
        addNode(head1, 8);
        addNode(head1, 5);
        addNode(head1, 6);
        addNode(head1, 3);

        Node head2 = new Node(8);
        addNode(head2, 4);
        addNode(head2, 2);

        System.out.println("Original Linked Lists");
        printList(head1);
        printList(head2);
        System.out.println("Addition Linked List");
        printList(addRecursion(head1, head2, getLength(head1), getLength(head1)));
    }

    private static Node addRecursion(Node node1, Node node2, int count, int len) {
        if(node1 == null || node2 == null)
            return null;

        while (getLength(node1) > getLength(node2)) {
            node2 = pushNode(node2, 0);
        }

        while (getLength(node1) < getLength(node2)) {
            node1 = pushNode(node1, 0);
        }

        Node resLink;
        int carry = 0;
        resLink = addRecursion(node1.next, node2.next, count -1 , len);
        if (resLink != null && resLink.data >=10) {
            carry = resLink.data / 10;
            resLink.data = resLink.data % 10;
        }
        int res = node1.data + node2.data + carry;
        resLink = pushNode(resLink, res);
        if (count == len && resLink.data >=10) {
            carry = resLink.data / 10;
            resLink.data = resLink.data % 10;
            resLink = pushNode(resLink, carry);
        }
        return resLink;
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
