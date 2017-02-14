package datastructure.line.stack.stackLinked;


import datastructure.Node;

/**
 * 节点定义
 * @author wangning
 *
 */
public class SLNode implements Node {

	// 数据域
	private Object element;
	
	// 节点
	private SLNode next;
	
	public SLNode() {
		this(null, null);
	}
	
	public SLNode(Object obj, SLNode note) {
		this.element = obj;
		this.next = note;
	}
	
	/**
	 * 获取节点
	 * @return
	 */
	public SLNode getNext() {
		return next;
	}
	
	/**
	 * 设置节点
	 * @param note
	 */
	public void setNext(SLNode note) {
		this.next = note;
	}
	
	/**
	 * 获取数据域
	 */
	public Object getData() {
		return element;
	}
	
	/**
	 * 设置数据域
	 * @param element
	 */
	public void setData(Object element) {
		this.element = element;
	}
	
}
