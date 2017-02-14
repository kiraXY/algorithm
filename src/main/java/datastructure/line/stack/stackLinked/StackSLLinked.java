package datastructure.line.stack.stackLinked;

import datastructure.line.stack.Stack;
import datastructure.line.stack.StackEmptyException;

/**
 * 链式存储
 * @author wangning
 *
 */
public class StackSLLinked implements Stack{

	// 指向首节点
	private SLNode top;
	
	// 规模
	private int size;

	public StackSLLinked() {
		this.size = 0;
		this.top = null;
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
	public void push(Object e) {
		SLNode s = new SLNode();
		
		s.setData(e);
		
		// 将原有元素后移一位
		s.setNext(top);
		
		// 将新元素设为 栈顶
		top = s;
		
		size ++;
			
	}

	@Override
	public Object pop() throws StackEmptyException {
		if(isEmpty()) throw new StackEmptyException("错误，空栈"); 
		
		// 获取栈顶节点的值
		Object data = top.getData();

		top = top.getNext();
		
		size --;
		return data;
	}

	@Override
	public Object peek() throws StackEmptyException {
		if(isEmpty()) throw new StackEmptyException("错误，空栈"); 
		
		return top.getData();
	}
	
}
