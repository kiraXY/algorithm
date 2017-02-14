package datastructure.line.nodeList.doubleNodeList.Iterator;

import datastructure.Node;

/**
 * 迭代器 接口
 * 
 * 迭代器就是对遍历操作的抽象
 * 顺序访问一个聚集对象中各个元素，而又不需要暴露该对象的内部表示
 * @author wangning
 *
 */
public interface Iterator {
	
	/** 移动到第一个元素 */
	void frist();
	/** 移动到下一个元素 */
	void next();
	
	/** 迭代器中是否还有元素 */
	boolean isDone();
	
	/** 返回当前对象 */
	Node currentItem();
}
