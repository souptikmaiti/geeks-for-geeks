import java.lang.Math;
public class _37_NumbersReprentedByLL {
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

    public static void main(String args[])
    {
        Node head1 = new Node(5);
        addNode(head1, 6);
        addNode(head1, 3);

        Node head2 = new Node(8);
        addNode(head2, 4);
        addNode(head2, 2);

        System.out.println("Original Linked Lists");
        printList(head1);
        printList(head2);
        printList(addNumbers(head1, head2));
    }

    private static Node addNumbers(Node head1, Node head2){
        int a = extractNumber(head1);
        int b = extractNumber(head2);
        int c = a + b;
        return convertNumToLL(c);
    }

    private static int extractNumber(Node head) {
        int res =0;
        int count = 0;

        while (head != null){
            res += head.data * Math.pow(10, count);
            head = head.next;
            count++;
        }
        return res;
    }

    private static Node convertNumToLL(int num) {
        Node head = null, tail = null;
        while (num >= 1) {
            int d = num % 10;
            Node n = new Node(d);
            if(head == null){
                head = tail = n;
            } else {
                tail.next = n;
                tail = tail.next;
            }
            num = num / 10;
        }
        return head;
    }
}
