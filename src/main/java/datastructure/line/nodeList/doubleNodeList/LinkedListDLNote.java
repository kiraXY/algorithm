package datastructure.line.nodeList.doubleNodeList;

import datastructure.Node;
import datastructure.line.nodeList.InvalidNodeException;
import datastructure.line.nodeList.OutOfBoundaryException;
import datastructure.line.nodeList.doubleNodeList.Iterator.Iterator;
import datastructure.line.nodeList.doubleNodeList.Iterator.LinkedListIterator;

public class LinkedListDLNote implements LinkedList {

    // 规模
    private int size;
    // 指向头结点
    private DLNode head;
    // 指向尾节点
    private DLNode tail;

    // 构建首尾节点 的链表
    public LinkedListDLNote() {
        size = 0;
        head = new DLNode();
        tail = new DLNode();

        head.setNext(tail);
        tail.setPre(head);
    }

    /**
     * 辅助判断p节点是否错误
     * @param p
     * @return
     * @throws InvalidNodeException
     */
    protected DLNode checkPosition(Node p) throws InvalidNodeException {
        if (p == null) {
        	throw new InvalidNodeException("错误，p 为空");
		}

        if (p == head) {
			throw new InvalidNodeException("错误, p 指向头节点, 非法");
		}

        if (p == tail) {
			throw new InvalidNodeException("错误, p 指向尾节点, 非法");
		}

        return (DLNode) p;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Node first() throws OutOfBoundaryException {

        if (isEmpty()) {
			throw new OutOfBoundaryException("错误，链表为空");
		}

        return head.getNext();
    }

    @Override
    public Node last() throws OutOfBoundaryException {
        if (isEmpty()) {
			throw new OutOfBoundaryException("错误，链表为空");
		}

        return tail.getPre();
    }

    @Override
    public Node getNext(Node p) throws OutOfBoundaryException, InvalidNodeException {

        DLNode node = checkPosition(p);

        if (node == tail) {
			throw new OutOfBoundaryException("错误，已经到链表最后");
		}

        return node.getNext();
    }

    @Override
    public Node getPre(Node p) throws OutOfBoundaryException, InvalidNodeException {

        DLNode node = checkPosition(p);

        if (node == head) {
			throw new OutOfBoundaryException("错误，已经到链表最后");
		}

        return node.getPre();
    }

    @Override
    public DLNode insertFirst(Object e) {
        // 构件新节点
        DLNode node = new DLNode();
        // 设置新节点的头尾指针
        node.setPre(head);
        node.setNext(head.getNext());
        node.setData(e);

        // 设置原先首节点的 前驱指针
        head.getNext().setPre(node);

        // 头指向新节点
        head.setNext(node);

        size++;

        return node;
    }

    @Override
    public Node insertLast(Object e) {
        // 构件新节点
        DLNode node = new DLNode();
        // 设置新节点的头尾指针
        node.setNext(tail);
        node.setPre(tail.getPre());
        node.setData(e);

        // 设置原先尾节点的 后续指针
        tail.getPre().setNext(node);
        // 尾指向新节点
        tail.setPre(node);

        size++;

        return node;
    }

    @Override
    public Node insertafter(Node node, Object obj) throws InvalidNodeException {

        DLNode p = checkPosition(node);

        // 建立新节点
        DLNode now = new DLNode();

        now.setData(obj);
        now.setPre(p);
        now.setNext(p.getNext());

        // 原先节点的上一个前驱指针修改为 新节点
        p.getNext().setPre(now);
        // p节点的 后续坐标修改为新节点
        p.setNext(now);

        size++;
        return now;
    }

    @Override
    public Node insertBefore(Node node, Object obj) throws InvalidNodeException {
        DLNode p = checkPosition(node);

        // 建立新节点
        DLNode now = new DLNode();

        now.setData(obj);
        now.setPre(p.getPre());
        now.setNext(p);

        // 原先节点的上一个后续指针修改为 新节点
        p.getPre().setNext(now);

        // p节点的 前驱坐标修改为新节点
        p.setPre(now);

        size++;
        return now;
    }

    @Override
    public Object remove(Node node) throws InvalidNodeException {
        DLNode p = checkPosition(node);
        // 被删除节点的前驱节点 的后续指针指向 被删除节点的 后续节点
        p.getPre().setNext(p.getNext());
        // 被删除节点后续结点 的前驱指针指向 被删除节点的 前驱节点
        p.getNext().setPre(p.getPre());

        size--;
        return p.getData();
    }

    @Override
    public Object removeFrist() throws OutOfBoundaryException {
        return remove(first());
    }

    @Override
    public Object removeLast() throws OutOfBoundaryException {
        return remove(last());
    }

    @Override
    public Object replace(Node node, Object obj) throws InvalidNodeException {
        DLNode p = checkPosition(node);

        Object o = p.getData();

        p.setData(obj);

        return o;
    }

    @Override
    public Iterator elements() {
        return new LinkedListIterator(this);
    }

}
