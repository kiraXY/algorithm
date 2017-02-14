package datastructure.line.nodeList;

/**
 * 自定义异常
 * 
 * 节点不合法
 * 
 * p == null
 * p 不存在与链接表中
 * 调用getPre 时 p是第一个存有数据的节点   （第一个节点前面没有 节点）
 * 调用getNext 时 p是最后一个存有数据的节点  （最后一个节点后面没有 节点）
 * @author wangning
 *
 */
@SuppressWarnings("serial")
public class InvalidNodeException extends RuntimeException{

	public InvalidNodeException(String err) {
		super(err);
	}
	
}
