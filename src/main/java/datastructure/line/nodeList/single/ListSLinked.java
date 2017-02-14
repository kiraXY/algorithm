package datastructure.line.nodeList.single;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import datastructure.line.nodeList.OutOfBoundaryException;

/**
 * 单向链表的实现
 * 
 * @author wangning
 *
 */
@SuppressWarnings("rawtypes")
public class ListSLinked implements List {

	// 指向链表的首节点
	private SLNode head;
	
	// 记录元素个数
	private int size;
	
	private SLNode tail;
	
	public ListSLinked() {
		head = new SLNode();
		size = 0;
	}
	
	
	/**
	 * 获取元素所在的 前驱节点
	 * @param obj
	 * @return
	 */
	public SLNode getPointPre(Object obj) {
		// 获取头元素
		SLNode p = head;
		
		while(p.getNext() != null) {
			if(p.getNext().getData().equals(obj)) return p; // 若p的后驱元素数据域中数据元素 等于 obj 则返回 p 
			
			else p = p.getNext();	// 或则p 等于下一个后驱元素
		}
		return null;
	}
	
	/**
	 * 获取下标存在于 0 <= i <= size 中的元素的前驱元素 
	 * @param i
	 * @return
	 */
	public SLNode getPointPre(int i) {
		SLNode p = head;
		
		for (; i > 0; i --) p = p.getNext();
			
		return p;
	}
	
	/**
	 * 获取下标 节点
	 * @param i
	 * @return
	 */
	public SLNode getNote(int i) {
		SLNode p = head.getNext();
		for (; i > 0; i --) p = p.getNext();
		return p;
	}


	/**
	 * 返回元素个数
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * 空集判断
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}


	/**
	 * 判断是否包含元素
	 */
	@Override
	public boolean contains(Object obj) {
		// 获取头元素
		SLNode p = head;
		
		while(p.getNext() != null) {
			if(p.getNext().getData().equals(obj)) return true; // 若p的后驱元素数据域中数据元素 等于 obj 则返回 p 
			
			else p = p.getNext();	// 或则p 等于下一个后驱元素
		}
		return false;
	}
	
	
	// 获取制定元素的下标
	@Override
	public int indexOf(Object obj) {
		// 指向第一个元素 下标为0
		SLNode p = head.getNext();
		int index = 0;
		
		while(p != null) {
			if(p.getData().equals(obj)) return index;
			
			else {index ++; p = p.getNext();}
		}
		
		return -1;
	}

	/**
	 * 将制定元素插入 i 下标
	 * @param i
	 * @param obj
	 */
	public void insert(int i, Object obj) {
		
		if(i < 0 || i > size) throw new OutOfBoundaryException("数组下标越界");
		
		// 获取 i 位置的前驱元素
		SLNode p = getPointPre(i);
		
		// 增加一个新的节点
		SLNode now = new SLNode();
		now.setData(obj);
		
		// 使新节点指向 i 前驱原来的 next 节点
		now.setNext(p.getNext());
		
		// 使p 指向 新节点
		p.setNext(now);
		
		// 修改元素个数
		size ++;
	}
	
	/**
	 * 删除第一个与指定元素相等的元素
	 */
	@Override
	public boolean remove(Object obj) {
		// 获取元素的前驱节点
		SLNode p = getPointPre(obj);
		
		if(p != null) {
			// 指定元素的 前驱next  节点 指向 制定元素的 后续节点
			p.setNext(p.getNext().getNext());
			
			size --;
			return true;
		}
		
		return false;
	}

	/**
	 * 根据下标删除元素， 并返回被删除的元素
	 * @param i
	 * @return
	 */
	public Object removeIndex(int i) {
		if(i < 0 || i > size) throw new OutOfBoundaryException("数组下标越界");
		
		// 获取制定下标的前驱元素
		SLNode p = getPointPre(i);
		
		// 获取元素
		Object result = p.getNext().getData();
		
		p.setNext(p.getNext().getNext());
		
		size --;
		return result;
	}

	/**
	 * 增加一个元素
	 */
	@Override
	public boolean add(Object element) {
		
		if(size == 0) {
			// 设置新节点
			SLNode now = new SLNode();
			now.setData(element);
			// 指向第一个节点
			head.setNext(now);
			
			// 保存最后一个节点
			tail = now;
			size ++;
			
			return true;
		} else {
			// 设置新节点
			SLNode now = new SLNode();
			now.setData(element);
			// 结尾节点保存 新的节点
			tail.setNext(now);
			
			// 记录结尾几点指向新的 结尾节点
			tail = now;
			size ++;
			return true;
		}
	}
	
	/**
	 * 从指定下标获取元素
	 */
	@Override
	public Object get(int index) {
		if(index < 0 || index > size) throw new OutOfBoundaryException("数组下标越界");
		
		SLNode p = getNote(index);
		
		return p.getData();
	}
	
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void add(int index, Object e) {
		// TODO Auto-generated method stub
	}





	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
