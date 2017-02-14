package datastructure.line.nodeList.doubleNodeList.Iterator;

import datastructure.Node;
import datastructure.line.nodeList.OutOfBoundaryException;
import datastructure.line.nodeList.doubleNodeList.LinkedList;

/**
 * 迭代器实现
 * 
 * @author wangning
 *
 */
public class LinkedListIterator implements Iterator {

    /** 持有需要迭代的聚集 */
    private LinkedList list;

    /** 当前节点 */
    private Node current;

    public LinkedListIterator(LinkedList t) {
        this.list = t;

        // 如果是空聚集 则当前元素为 null
        if (list.isEmpty()) {
            current = null;

        } else {  // 不是空则为第一个元素
            current = list.first();
        }

    }

    @Override
    public void frist() {
        // 如果是空聚集 则当前元素为 null
        if (list.isEmpty())
            current = null;

        // 不是空则为第一个元素
        else
            current = list.first();
    }

    @Override
    public void next() {

        if (isDone())
            throw new OutOfBoundaryException("已经没有元素了");

        // 如果是空聚集 则当前元素为 null
        if (list.isEmpty())
            current = null;

        // 已经是最后一个元素，没有后续元素了
        else if (current == list.last())
            current = null;

        else
            current = list.getNext((Node) current);
    }

    @Override
    public boolean isDone() {
        return current == null;
    }

    @Override
    public Node currentItem() {
        return current;
    }

}
