import datastructure.line2.ListNode;

public class isPalindrome {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(1);
        a.setNext(b);
        b.setNext(c);
//        c.setNext(d);
//        d.setNext(e);
//        e.setNext(f);
        isPalindrome(a);

    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next() == null) {
            return true;
        }
        if ((head.getValue() != head.next().getValue()) && head.next().next() == null) {
            return false;
        }
        ListNode pre = head;
        ListNode next = head.next();

        boolean isEven = true;
        while (next.hasNext()) {
            if (next.hasNext()) {
                next = next.next();
            }

            if (!next.hasNext()) {
                isEven=false;
            } else {
                next = next.next();
            }
            if(!isEven){
                break;
            }
            pre = pre.next();
        }
        ListNode tail = revert(isEven?pre.next():pre.next().next());

        while (tail.hasNext()) {
            if (tail.getValue() != head.getValue()) {
                return false;
            }
            tail = tail.next();
            head = head.next();
        }


        return true;

    }

    public static ListNode revert(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;

    }
}
