package datastructure.line.queue.array;

import datastructure.line.queue.Queue;
import datastructure.line.queue.QueueEmptyException;

/**
 * 有序队列的实现
 * 
 * 循环数组 概念
 * 
 * 为了提高运算效率，我们用另一个方法来表示数组中各个单元的位置关系。
 * 摄像数组A[0......length-1]中的单元不是排成一行，而是围成一个圆环，即A[0] 接在 A[length-1] 后面
 * 
 * 使用队标记法 扩充数组容量的策略
 * 
 * @author wangning
 *
 */
public class QueueArray implements Queue{
	
	// 循环数组默认大小
	private final static int CAP = 7;
	
	// 元素数组
	private Object[] elements;
	
	// 数组的大小
	private int length;
	
	// 队首指针
	private int front;
	
	// 队尾指针
	private int rear;
	
	
	public QueueArray() {
		this(CAP);
	}
	
	public QueueArray(int cap) {
		this.length = cap + 1;
		elements = new Object[length];
		
		// 初始为 0 空队列
		front = rear = 0;
	}

	@Override
	public int getSize() {
		// 由于数组一直在循环，队首指针与队尾指针一直增加，超出了数组长度，所以用取模的方式保证 对应的下标不越界并且正确
		return (rear - front + length) % length;
	}

	@Override
	public boolean isEmpty() {
		return rear == front;
	}

	@Override
	public void enQueue(Object e) {
		// 元素个数等于数组长度 - 1
		if(getSize() == length - 1) expandSpace(); 
		
		elements[rear] = e;
		
		// 将队尾指针移动到下一个
		rear = (rear + 1) % length;
		
		
	}
	
	/**
	 * 动态扩充容量
	 */
	private void expandSpace() {
		Object[] o = new Object[elements.length * 2];
		
		int i = 0;
		int j = front;
		
		while(j != rear) {  // 从front开始将  front 到 rear 之间的元素放入新数组
			o[i++] = elements[j];
			
			// 获取j对应elements 的下标
			j = (j + 1) % length; 
		}
		
		elements = o;
		
		// 设置新的 队头
		front = 0;
		// 设置新的队尾
		rear = i;
		
		// 设置新的数组长度
		length = elements.length;
		
		// 辅助测试
//		System.out.println(length);
	}

	@Override
	public Object deQueue() throws QueueEmptyException {
		if(isEmpty()) throw new QueueEmptyException("错误，队列为空");
		
		Object o = elements[front];
		
		// 清空队列出列位置单元
		elements[front] = null;
		// 队首指针后移
		front = (front + 1) % length;
		return o;
	}

	@Override
	public Object peek() throws QueueEmptyException {
		if(isEmpty()) throw new QueueEmptyException("错误，队列为空");
		
		return elements[front];
	}

}
