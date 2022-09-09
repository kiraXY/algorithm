import datastructure.line2.ListNode;

public class reverseKGroup {
    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);

        ListNode reverss = a(a);
        ListNode listNode = reverseKGroup(a, 2);
        System.out.println();
        System.out.println();


    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dy=new ListNode(1);
        dy.setNext(head);
        ListNode end = dy;
        ListNode pre = dy;
        while (end.hasNext()) {
            for (int i = 0; i < k && end.next() != null; i++) {
                end = end.next();
            }
            ListNode next =end.next();
            ListNode start=pre.next();
            end.setNext(null);
            end=next;
//            pre.setNext( revers(start));
        }
        return null;
    }


    private static ListNode a(ListNode head){
        if( head==null){
            return head;
        }
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next = cur.next();
            cur.setNext(pre);
            pre=cur;
            cur=next;
        }
        return pre;

    }
    private static ListNode reverss(ListNode head) {
        if(head==null|| head.next()==null){
            return head;
        }

        ListNode rever=reverss(head.next());
        head.next().setNext(head);
//        rever.setNext(head);
        head.setNext(null);
        return rever;

    }




    private static ListNode reverss2(ListNode head) {
        if(head==null|| head.next()==null){
            return head;
        }

        ListNode rever=reverss(head.next());
        head.next().setNext(head);
//        rever.setNext(head);
        head.setNext(null);
        return rever;

    }

        private static ListNode revers(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next();
            curr.setNext(pre);
            pre = curr;
            curr = next;
        }
        return pre;
    }


}


