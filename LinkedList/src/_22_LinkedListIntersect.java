import java.util.HashSet;

public class _22_LinkedListIntersect {

    public static void main(String[] args)
    {
        // list 1
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);
        // list 2
        Node n2 = new Node(10);
        n2.next = new Node(9);
        n2.next.next = new Node(8);
        n2.next.next.next = new Node(7);
        n2.next.next.next.next = n1.next.next.next;
        Print(n1);
        Print(n2);
        System.out.println(intersectPoint3(n1, n2));
    }

    // function to print the list
    public static void Print(Node n)
    {
        Node cur = n;
        while (cur != null) {
            System.out.print(cur.data + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

    // function to find the intersection of two node
    public static int intersectPoint1(Node n1, Node n2)
    {
        // define hashset
        HashSet<Node> hs = new HashSet<Node>();
        while (n1 != null) {
            hs.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (hs.contains(n2)) {
                return n2.data;
            }
            n2 = n2.next;
        }
        return -1;
    }

    static int intersectPoint2(Node headA, Node headB)
	{
	    int lenA = getLength(headA);
	    int lenB = getLength(headB);
	    if(lenA > lenB) {
	        int d = lenA - lenB;
	        for(int i=0; i<d; i++)
	            headA = headA.next;
	    }else if(lenA < lenB) {
	        int d = lenB - lenA;
	        for(int i=0; i<d; i++)
	            headB = headB.next;
	    }
        while(headA != null && headB != null) {
            if(headA == headB) {
                return headA.data;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return -1;
	}

	static int getLength(Node n) {
	    int i= 0;
	    Node t = n;
	    while(t != null) {
	        i ++;
	        t = t.next;
	    }
        return i;
	}

    static int intersectPoint3(Node headA, Node headB) {
        if(headA == null || headB == null)
            return -1;
        int loop = 1;
        Node tempA = headA, tempB = headB;
        while(tempA !=  tempB && loop<3) {
            tempA = tempA.next;
            tempB = tempB.next;
            if(tempA == null) {
                tempA = headB;
                loop ++;
            }
            if(tempB == null)
                tempB = headA;
            if(tempA == tempB) {
                return tempA.data;
            }
        }
        return -1;
    }
}
