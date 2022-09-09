import datastructure.line2.ListNode;

import java.util.List;
import java.util.Map;

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

        if (head == null || head.getNext() == null) {
            return true;
        }
        if ((head.getValue() != head.getNext().getValue()) && head.getNext().getNext() == null) {
            return false;
        }
        ListNode pre = head;
        ListNode next = head.getNext();

        boolean isEven = true;
        while (next.hasNext()) {
            if (next.hasNext()) {
                next = next.getNext();
            }

            if (!next.hasNext()) {
                isEven=false;
            } else {
                next = next.getNext();
            }
            if(!isEven){
                break;
            }
            pre = pre.getNext();
        }
        ListNode tail = revert(isEven?pre.getNext():pre.getNext().getNext());

        while (tail.hasNext()) {
            if (tail.getValue() != head.getValue()) {
                return false;
            }
            tail = tail.getNext();
            head = head.getNext();
        }


        return true;

    }

    public static ListNode revert(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;

    }
}
