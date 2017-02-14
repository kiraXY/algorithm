package datastructure.line.nodeList.doubleNodeList;

import datastructure.Node;


/**
 * 双向链表的节点实现
 * @author wangning
 *
 */
public class DLNode implements Node {

	// 指向上一个节点
	private DLNode pre;
	// 指向下一个节点
	private DLNode next;
	// 指向数据域
	private Object data;
	
	
	
	public DLNode getPre() {
		return pre;
	}
	
	public void setPre(DLNode pre) {
		this.pre = pre;
	}
	
	public DLNode getNext() {
		return next;
	}
	
	public void setNext(DLNode node) {
		this.next = node;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
