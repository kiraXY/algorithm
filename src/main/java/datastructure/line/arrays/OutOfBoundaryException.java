package datastructure.line.arrays;


/**
 * 数组抛出的异常
 * @author wangning
 *
 */
@SuppressWarnings("serial")
public class OutOfBoundaryException extends RuntimeException{
	public OutOfBoundaryException(String err) {
		super(err);
	}
}
