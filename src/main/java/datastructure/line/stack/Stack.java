package datastructure.line.stack;

/**
 * 栈定义接口
 * 
 * 逻辑结构属于线性表
 * 
 * 由于操作都于栈顶完成， 所以是一种操作受限制的 线性表
 * 
 * 栈顶的元素称为 栈顶元素 
 * 
 * 将元素压入栈中第一个位置 称为 入栈或进栈
 * 
 * 从栈顶取出一个元素称为 出栈或退栈
 * 
 * 因为只能从栈顶操作元素，所以是一种后进先出的 线性表
 * 
 * 	入栈
 * 		A B C D
 *  出栈
 *  	D C B A 
 * 
 * @author wangning
 *
 */
public interface Stack {
	
	/** 获取规模 */
	public int getSize();
	
	/** 判断是否为空 */
	public boolean isEmpty();
	
	/** 入栈操作 */
	public void push(Object e);
	
	/** 出栈操作 */
	public Object pop() throws StackEmptyException;
	
	/** 取栈顶元素但是不出栈 */
	public Object peek() throws StackEmptyException;

}
