package datastructure.line.queue;
/**
 * 队列接口定义
 * @author wangning
 *
 */
public interface Queue {

	/** 返回规模 */
	int getSize();
	
	/** 判空 */
	boolean isEmpty();
	
	/** 入队 */
	void enQueue(Object e);
	
	/** 出队 */
	Object deQueue() throws QueueEmptyException;
	
	/** 获取队首元素但是不出队 */
	Object peek() throws QueueEmptyException;
}
