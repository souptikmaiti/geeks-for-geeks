public class LL1 {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    public static void main(String[] args){


        LL1 linkedList = new LL1();
        Node head = new LL1.Node(1);
        Node second = new LL1.Node(2);
        Node third = new LL1.Node(3);
        Node fourth = new LL1.Node(4);

        linkedList.head = head;
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        printList(linkedList);

    }

    public static void printList(LL1 ll1){
        Node temp = ll1.head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
