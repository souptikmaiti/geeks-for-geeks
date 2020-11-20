public class _39_TripletsForGivenSum {
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

    public static void main(String args[]) {

        //100->15->5->20
        Node a = new Node(100);
        addNode(a, 15);
        addNode(a, 5);
        addNode(a, 20);

        //2->4->9->10 (sorted in ascending order)
        Node b = new Node(2);
        addNode(b, 4);
        addNode(b, 9);
        addNode(b, 10);

        //8->4->2->1 (sorted in descending order)
        Node c = new Node(8);
        addNode(c, 4);
        addNode(c, 2);
        addNode(c, 1);

        System.out.println("Original Linked Lists");
        printList(a);
        printList(b);
        printList(c);
        int sum = 25;
        printList(findTriplets(a, b , c, sum));
    }

    private static Node findTriplets(Node a, Node b, Node c, int sum) {
        Node aNode = a;
        Node bNode = b;
        Node cNode = c;

        while (aNode != null){
            bNode = b;
            cNode = c;

            while (bNode != null && cNode != null ) {
                int s = aNode.data + bNode.data + cNode.data;
                if(s > sum){
                    cNode = cNode.next;
                }else if(s < sum){
                    bNode = bNode.next;
                }else {
                    Node nHead = new Node(aNode.data);
                    addNode(nHead, bNode.data);
                    addNode(nHead, cNode.data);
                    return nHead;
                }
            }
            aNode = aNode.next;
        }
        return null;
    }

}
