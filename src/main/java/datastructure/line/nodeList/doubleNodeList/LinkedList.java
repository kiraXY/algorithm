package datastructure.line.nodeList.doubleNodeList;


import datastructure.Node;
import datastructure.line.nodeList.InvalidNodeException;
import datastructure.line.nodeList.OutOfBoundaryException;

/**
 * 连接表接口
 * @author wangning
 *
 */
public interface LinkedList {
	
	/** 返回规模 */
	int size();

	/** 判断是否为空 */
	boolean isEmpty();
	
	/** 返回第一个节点 */
	Node first() throws OutOfBoundaryException;
	
	/** 返回最后一个节点 */
	Node last() throws OutOfBoundaryException;
	
	/** 返回p 之后的节点 */
	Node getNext(Node p) throws OutOfBoundaryException, InvalidNodeException;
	
	/** 返回p 之前的节点 */
	Node getPre(Node p) throws OutOfBoundaryException, InvalidNodeException;
	
	/** 将e作为第一个节点插入 */
	Node insertFirst(Object e);
	
	/** 将e作为最后个节点插入 */
	Node insertLast(Object e);
	
	/** 将e 插入到p之后的位置 并返回e所在的节点 */
	Node insertafter(Node node, Object obj) throws InvalidNodeException;
	
	/** 将e 插入到p之前的位置 并返回e所在的节点 */
	Node insertBefore(Node node, Object obj) throws InvalidNodeException;
	
	/** 删除指定位置元素 并返回 */
	Object remove(Node node) throws InvalidNodeException;
	
	/** 删除第一个元素 并返回 */
	Object removeFrist() throws OutOfBoundaryException;
	
	/** 删除最后个元素 并返回 */
	Object removeLast() throws OutOfBoundaryException;
	
	/** 替换指定位置元素，并返回 */
	Object replace(Node node, Object obj) throws InvalidNodeException;
	
	/** 返回元素迭代器 */
	datastructure.line.nodeList.doubleNodeList.Iterator.Iterator elements();
	
}
