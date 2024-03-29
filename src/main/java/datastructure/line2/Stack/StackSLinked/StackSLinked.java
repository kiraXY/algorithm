package datastructure.line2.Stack.StackSLinked;

import datastructure.line2.Stack.Stack;
import datastructure.line2.Stack.StackEmptyException;
import datastructure.line2.nodeList.SLNode;

/**
 * Created by wangning on 2017/2/16.
 */
public class StackSLinked implements Stack<Number> {
    private SLNode top; //链表首结点引
    private int size; //栈的大小

    public StackSLinked() {
        top = null;
        size = 0;
    }

    //返回堆栈的大小
    public int getSize() {
        return size;
    }

    //判断堆栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //数据元素 e 入栈
    public void push(Object e) {
        SLNode q = new SLNode(e, top);
        top = q;
        size++;
    }

    //栈顶元素出栈
    public Object pop() throws StackEmptyException {
        if (size < 1)
            throw new StackEmptyException("错误，堆栈为空。");
        Object obj = top.getData();
        top = top.getNext();
        size--;
        return obj;
    }

    //取栈顶元素
    public Object peek() throws StackEmptyException {
        if (size < 1)
            throw new StackEmptyException("错误，堆栈为空。");
        return top.getData();
    }
}
