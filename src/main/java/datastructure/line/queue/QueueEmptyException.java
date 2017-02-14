package datastructure.line.queue;

/**
 * 自定义异常
 * 
 * 空队列时，调用出队操作抛出异常
 * @author wangning
 *
 */
@SuppressWarnings("serial")
public class QueueEmptyException extends RuntimeException{

	public QueueEmptyException(String err) {
		super(err);
	}
}
