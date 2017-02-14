package datastructure.line.queue.theList;

import datastructure.line.queue.Queue;
import datastructure.line.queue.QueueEmptyException;

/**
 * 队列的链表实现
 * @author wangning
 *
 */
public class QueueTheList implements Queue{
	// 队首节点
	private SLNode front;
	
	// 队尾节点
	private SLNode rear;

	// 规模
	private int size;
	
	public QueueTheList() {
		front = new SLNode();
		rear = front;
		
		size = 0;
	}
	
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enQueue(Object e) {
		SLNode p = new SLNode();
		p.setData(e);
		
		// 当size = 0时   front = rear      rear.setNext(p) 等价于  front.setNext(p)
		// 当size != 0时， rear = 上一个P  front.getNext() 等于之前保存的p  
		rear.setNext(p);
		
		// 队尾指针指向 最新一个元素
		rear = p;
		
		size ++;
		
	}

	@Override
	public Object deQueue() throws QueueEmptyException {
		if(size < 1) throw new QueueEmptyException("错误，空队列");
		// 获取第一个节点
		SLNode p = front.getNext();
		
		// 使队首指针指向 出队元素的后一个元素
		front.setNext(p.getNext());
		
		size --;
		
		// 如果队列中元素个数小于1 则说明没有元素了，使队尾指针指等于队首
		if(size < 1) rear = front;
		
		return p.getData();
	}

	@Override
	public Object peek() throws QueueEmptyException {
		if(size < 1) throw new QueueEmptyException("错误，空队列");
		
		return front.getNext().getData();
	}
}
