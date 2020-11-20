class GFG {
    Node head;

    public void pushNode(int d) {
        Node node = new Node(d);
        node.next = head;
        head = node;
    }

    public void printList() {
        Node tmp = head;
        while(tmp != null) {
            System.out.print(tmp.data + "-> ");
            tmp = tmp.next;
        }
        System.out.println("");
    }

    public Node pairwiseSwap(Node head) {
        Node tmp = head;
        if(tmp == null || tmp.next == null)
            return head;


        /*while(tmp != null && tmp.next != null) {
            int curr = tmp.data;
            int tmpNxt = tmp.next.data;
            tmp.data = tmpNxt;
            tmp.next.data = curr;
            tmp = tmp.next.next;
        }*/

        while(tmp != null && tmp.next != null) {
            Node curr = tmp;
            Node a = curr;
            Node tmpNxt = tmp.next;

            curr = tmpNxt;
            tmpNxt = a;

            tmp = tmp.next.next;
        }
        return head;
    }

    public void swapNodes(int x, int y) {
        if(x == y)
            return;
        boolean xFound = false, yFound = false, xHead = false;
        Node tmpx = head, tmpy = head;
        Node xBef = null, xAft = null, yBef = null, yAft = null;

        if(head.data == x) {
            xFound = true;
            xHead = true;
            xAft = head.next;
        }
        while(tmpx != null && !xHead) {
            xBef = tmpx;
            tmpx = tmpx.next;
            if(tmpx != null && tmpx.data == x){
                xFound = true;
                xAft = tmpx.next;
                break;
            }
        }

        while(tmpy != null) {
            yBef = tmpy;
            tmpy = tmpy.next;
            if(tmpy != null && tmpy.data == y){
                yFound = true;
                yAft = tmpy.next;
                break;
            }
        }

        if( !xFound || !yFound)
            return;

        if(xHead) {
            if(xAft == tmpy) {
                head = tmpy;
                head.next = tmpx;
                head.next.next = yAft;
            } else {
                head = tmpy;
                head.next = xAft;
                yBef.next = tmpx;
                tmpx.next = yAft;
            }
            return;
        }

        if(xAft == tmpy) {
            xBef.next = tmpy;
            tmpy.next = tmpx;
            tmpx.next = yAft;
            return;
        }

        xBef.next = tmpy;
        tmpy.next = xAft;
        yBef.next = tmpx;
        tmpx.next = yAft;

    }

    void moveToFront() {
        if(head == null || head.next == null)
            return;

        Node tmp = head, sndLast = null;

        while(tmp.next != null) {
            sndLast = tmp;
            tmp = tmp.next;
        }

        sndLast.next = null;
        tmp.next = head;
        head = tmp;

    }

    public static void main (String[] args) {
        GFG linkedList = new GFG();
		/* The constructed linked list is:
            1->2->3->4->5->6->7 */
        linkedList.pushNode(7);
        linkedList.pushNode(6);
        linkedList.pushNode(5);
        linkedList.pushNode(4);
        linkedList.pushNode(3);
        linkedList.pushNode(2);
        linkedList.pushNode(1);

        linkedList.printList();

        //linkedList.swapNodes(1, 2);
        //linkedList.pairwiseSwap(linkedList.head);
        linkedList.moveToFront();
        linkedList.printList();
    }
}
