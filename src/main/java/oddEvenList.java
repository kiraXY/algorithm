import datastructure.line2.ListNode;

public class oddEvenList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
//        e.setNext(f);
        reversePrint(a);
//        oddEvenList(a);
        System.out.println();
    }

    public static void reversePrint(ListNode head){

        if(head.next()!=null){
            reversePrint(head.next());
        }
        System.out.println(head.getValue());
    }
    public static void oddEvenList(ListNode head) {
        if (head == null || head.next() == null) {
            return;
        }
        ListNode start = head;
        ListNode evenStart = head.next();
        ListNode even = head.next();

        while (even!= null) {
            if (even.next() == null||start.next()==null) {
                break;
            }
            ListNode star2 = start.next().next();
            start.setNext(start.next().next());
            start = star2;

            ListNode even2 = even.next().next();
            even.setNext(even.next().next());
            even = even2;
        }
        start.setNext(evenStart);
    }
}

