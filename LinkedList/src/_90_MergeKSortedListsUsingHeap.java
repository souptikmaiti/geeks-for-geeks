import java.util.Comparator;
import java.util.PriorityQueue;

public class _90_MergeKSortedListsUsingHeap {

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
        int k = 3;
        Node[] nodes = new Node[k];
        nodes[0] = createList(1,3,5,7);
        nodes[1] = createList(2,4,6,8);
        nodes[2] = createList(0,9,10,11);

        System.out.println("Original Lists");
        printList(nodes[0]);
        printList(nodes[1]);
        printList(nodes[2]);
        System.out.println("After Merge");
        printList(mergeKListsUsingHeap(nodes, k));
    }

    static Node mergeKListsUsingHeap(Node[] nodes, int k) {
        Node head = null, tail = null;

        // priority_queue implemented as min heap with the help of 'compare' function
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return node1.data - node2.data;
            }
        });

        for (int i = 0; i<k ; i++) {
            priorityQueue.add(nodes[i]);
        }

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll(); // always give smallest node in the heap
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
        return head;
    }
}
