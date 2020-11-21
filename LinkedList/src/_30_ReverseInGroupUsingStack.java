import java.util.Stack;

public class _30_ReverseInGroupUsingStack {
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

    public static void main(String[] args)
    {
        Node head = new Node(1);
        addNode(head, 2);
        addNode(head, 3);
        addNode(head, 4);
        addNode(head, 5);
        addNode(head, 6);
        addNode(head, 7);
        addNode(head, 8);
        addNode(head, 9);
        addNode(head, 10);
        addNode(head, 11);


        System.out.println("Original Linked Lists");
        printList(head);
        System.out.println("After Group Reverse");
        printList(reverseInGroup(head, 4));

    }

    private static Node reverseInGroup(Node head, int group){
        Stack<Node> nodeStack = new Stack<>();
        Node newHead = null, tmp = null;

        while ( head != null) {
            if(nodeStack.size() == group){
                if(newHead == null) {
                    newHead = nodeStack.pop();
                    tmp = newHead;
                }
                while (!nodeStack.empty()) {
                    Node j = nodeStack.pop();
                    tmp.next = j;
                    tmp =j;
                }
                tmp.next = null;
            }
            nodeStack.push(head);
            head = head.next;
        }

        while (!nodeStack.empty()) {
            Node j = nodeStack.pop();
            if(tmp == null) {
                newHead = j;
                tmp = newHead;
            } else {
                tmp.next = j;
                tmp = j;
            }
            tmp.next = null;
        }
        return newHead;
    }
}
