package datastructure.line.stack.StackArray;

import datastructure.line.stack.Stack;
import datastructure.line.stack.StackEmptyException;

/**
 * 栈的有序实现
 * 
 * 栈的 有序实现
 * 
 * 因此在顺序栈的实现中需要设置一个指针top 来动态的指示栈顶元素在数组中的位置，通常top可以用栈顶元素所在数组下标来表示，top=-1 时表示空栈
 * @author wangning
 *
 */
public class StackArray<T> implements Stack {
	
	// 栈 默认 大小
	private final int LEN = 8;
	
	// 数据元素数组
	private Object[] elements;
	
	// 栈顶指针
	private int top;
	
	public StackArray() {
		this.elements = new Object[LEN];
		// 起始位置为 -1 表示空栈
		this.top = -1;
	}
	
	
	
	@Override
	public int getSize() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		return top < 0;
	}

	@Override
	public void push(Object e) {
		if(getSize() >= elements.length) expandSpace();
		elements[++ top] = e;
	}
	
	/**
	 * 扩充元素数组容量
	 */
	private void expandSpace() {
		Object[] o = new Object[elements.length * 2];
		
		for (int i = 0; i < elements.length; i++)
			o[i] = elements[i];
		
		elements = o;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		if(isEmpty()) throw new StackEmptyException("错误，空栈");
		
		Object o = elements[top];
		elements[top --] = null;
		return (T) o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		if(isEmpty()) throw new StackEmptyException("错误，空栈");
		
		return (T) elements[top];
	}

}
