import java.util.HashMap;

public class _94_Union_Intersection {

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

        Node head1 = createList(1 , 2 , 3 , 4);
        Node head2 = createList(3 , 4 , 8 , 10);

        System.out.println("Linked List");
        printList(head1);
        printList(head2);
        System.out.println("Union");
        printList(unionIntersection(head1, head2)[0]);
        System.out.println("Intersection");
        printList(unionIntersection(head1, head2)[1]);
    }

    static Node[] unionIntersection(Node head1, Node head2) {
        Node union = null, intersection = null;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (Node h = head1; h != null ; h = h.next) {
            hashMap.put(h.data, hashMap.containsKey(h.data)?hashMap.get(h.data)+1 : 1);
        }
        for (Node h = head2; h != null ; h = h.next) {
            hashMap.put(h.data, hashMap.containsKey(h.data)?hashMap.get(h.data)+1: 1);
        }

        for (Integer key : hashMap.keySet()) {
            if (hashMap.get(key) > 1) {
                if (intersection == null)
                    intersection = new Node(key);
                else {
                    addNode(intersection, key);
                }
            }

            if (union == null)
                union = new Node(key);
            else {
                addNode(union, key);
            }

        }
        return new Node[]{union, intersection};
    }
}
