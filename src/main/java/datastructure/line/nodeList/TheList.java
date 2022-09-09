package datastructure.line.nodeList;



import datastructure.line.nodeList.single.ListSLinked;

/**
 * 测试单向链表
 * @author wangning
 *
 */
public class TheList {

	
	public void test() {
		ListSLinked l = new ListSLinked();
		
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		System.out.println(l.isEmpty());
		System.out.println(l.size());
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));			
		}
		
		System.out.println("==================================");
		
		
		l.insert(1, 1.5);
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));			
		}
		
		System.out.println("==================================");
		
		
		l.removeIndex(1);
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));			
		}
		
		System.out.println("==================================");
		
	}
}
