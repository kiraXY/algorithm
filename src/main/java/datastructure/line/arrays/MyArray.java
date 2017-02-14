package datastructure.line.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * 线性表的顺序存储是一组连续的存储单元 依次存储存储数据元素
 * 
 * 如果数据表存储的元素 是 对象 那么数组中的线性指的的是对象的引用
 * @author wangning
 *
 */
@SuppressWarnings("rawtypes")
public class MyArray implements List{
	
	// 数组默认的长度
	private final int LEN = 8;
	
	// 线性表中的元素个数
	private int size;
	
	// 数据元素数组
	private Object[] elements;
	
	public MyArray() {
		elements = new Object[LEN];
	}
	
	public MyArray(int i) {
		elements = new Object[i];
	}

	/**
	 * 返回线性表的元素个数
	 */
	@Override
	public int size() {
		return this.size;
	}
	
	
	/**
	 * 根据线性表的元素个数判断 线性表是否为空
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 返回长度
	 * @return
	 */
	public int length() {
		return size;
	}
	
	/**
	 * 判断线性表是否存在 指定元素
	 */
	@Override
	public boolean contains(Object obj) {
		for (int i = 0; i < size; i++) {
			// 判断两个对象的 hash 是否一致
			if(elements[i].hashCode() == obj.hashCode()) {
				return true;
			} 
		}
		return false;
	}

	/**
	 * 返回对象在线性表中的位置
	 */
	@Override
	public int indexOf(Object obj) {
		for (int i = 0; i < size; i++) {
			// 如果线性表中存在该对象返回对应下标
			if(contains(obj)) return i;
		}
		return -1;
	}
	
	

	/**
	 * 扩充数组容量
	 */
	public void expandSpace(int minCapacity) {
		int oldCapacity = elements.length;
		//比较，如果不足则扩容
		if (minCapacity > oldCapacity) {
			Object oldData[] = elements;
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			// 调用效率较高的arraycopy
			elements = Arrays.copyOf(elements, newCapacity);
		}

	}

	/**
	 * 增加一个元素
	 */
	@Override
	public boolean add(Object e) {
		if(size == elements.length -1) {
			expandSpace(size+1);
		}
		elements[size] = e;
		
		size ++;
		return true;
	}
	
	/**
	 * 获取一个元素
	 */
	@Override
	public Object get(int index) {
		if(index >= size || index < 0) {
			throw new MyException("下标不合法");
		}
		
		return elements[index];
	}
	
	/**
	 * 删除与 指定元素一样的第一个元素 并返回
	 */
	@Override
	public boolean remove(Object obj) {
		int check = indexOf(obj);
		
		if(check != -1) removeIndex(check);
		
		return false;
	}
	
	/**
	 * 根据下标删除
	 * 注意点： 由于元素减少一个，所以循环可以减少一次 
	 * [0,1,2] 删除下标为 1 的元素  此时  size = 3
	 * 
	 * if  1 < 3 则循环两次
	 * 
	 * 第一次: arr[1] = arr[1 + 1]    
	 * 第二次: arr[2] = arr[2 + 1]     此时下标3 为null 
	 *
	 */
	public Object removeIndex(int index) {
		if(index >= size || index < 0) {
			throw new MyException("下标不合法");
		}
		Object obj = elements[index];
		
		for (int i = index; i < size-1; i++) {
			elements[i] = elements[i + 1];
		}
		size --;
		return obj;
		
	}
	
	
	@Override
	public Iterator iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		return null;
	}




	@Override
	public boolean containsAll(Collection c) {
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		return false;
	}

	@Override
	public void clear() {
		
	}


	@Override
	public Object set(int index, Object element) {
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// 线性表具有连续性， 如果大于size 则数据不连续 抛出异常
		if(index > size || index < 0) {
			throw new OutOfBoundaryException("数组下标越界");
		}

		// 如果大于数组长度则扩充容量
		if(size+1 > elements.length) {
			expandSpace(size+1);
		}

		// 将i后的元素向后移动一位
		for (int j = size; j > index; j--) {
			elements[j] = elements[j - 1];
		}
		elements[index] = element;

		size ++;
	}

	@Override
	public Object remove(int index) {
		return null;
	}



	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		return null;
	}
	

}
