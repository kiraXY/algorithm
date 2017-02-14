package datastructure.line.stack.StackArray;

import org.junit.Test;

public class StackArrayTest {

	@Test
	public void test() {
		StackArray<Integer> s = new StackArray<Integer>();
		
		s.push(1);
		System.out.println(s.getSize());
		System.out.println();
		s.push(2);
		System.out.println(s.getSize());
		System.out.println();
		s.push(3);
		System.out.println(s.getSize());
		System.out.println();
		s.push(4);
		System.out.println(s.getSize());
		System.out.println();
		s.push(5);
		System.out.println(s.getSize());
		System.out.println();
		s.push(6);
		System.out.println(s.getSize());
		System.out.println();
		
		
		for (int i = s.getSize(); i > 0; i--) {
			System.out.println(s.pop());
		}
		
		
	}
}
