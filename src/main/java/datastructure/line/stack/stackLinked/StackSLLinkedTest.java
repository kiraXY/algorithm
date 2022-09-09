package datastructure.line.stack.stackLinked;



/**
 * 基于链表 的 栈
 * @author wangning
 *
 */
public class StackSLLinkedTest {

	
	public void test() {
		StackSLLinked s = new StackSLLinked();
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		
		for (int i = s.getSize(); i > 0; i--) {
			System.out.println(s.pop());
		}
		
		try {
			// 测试异常
			s.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
