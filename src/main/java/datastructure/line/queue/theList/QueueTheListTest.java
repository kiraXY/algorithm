package datastructure.line.queue.theList;



public class QueueTheListTest {

	
	public void test() {
		QueueTheList q = new QueueTheList();
		
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		
		
		for (int i = q.getSize(); i > 0; i--) {
			System.out.println(q.deQueue());
		}
	}
}
