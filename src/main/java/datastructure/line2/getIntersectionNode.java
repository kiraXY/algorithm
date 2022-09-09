package datastructure.line2;

public class getIntersectionNode {

    public ListNode  getIntersectionNode( ListNode headA,ListNode headB){

        if(headA==null || headB==null){
            return null;
        }
        ListNode pointA=headA;
        ListNode pointB=headB;

        while (pointB!=pointA){
            if(pointA==null){
                pointA=headB;
            }else {
                pointA=pointA.next();
            }

            if(pointB==null){
                pointB=headA;
            }else {
                pointB=pointB.next();
            }
        }
        return pointA;

    }
}
