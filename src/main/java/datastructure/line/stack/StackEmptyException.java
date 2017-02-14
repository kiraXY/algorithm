package datastructure.line.stack;

/**
 * 自定义异常
 * 
 * 空栈时，调用出栈操作抛出
 * 
 * @author wangning
 *
 */
@SuppressWarnings("serial")
public class StackEmptyException extends RuntimeException{

	public StackEmptyException(String err) {
		super(err);
	}
}
