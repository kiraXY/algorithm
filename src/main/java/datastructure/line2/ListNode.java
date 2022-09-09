package datastructure.line2;

public class ListNode {
    private ListNode next;
    private int value;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public boolean hasNext(){
        return next!=null;
    }
}
