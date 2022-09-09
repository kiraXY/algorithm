package datastructure.line.queue.array;



public class QueueArrayTest {

	
	public void test() {
		QueueArray q = new QueueArray();
		
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
		q.enQueue(7);
		q.enQueue(8);
		q.enQueue(9);
		
		System.out.println(q.getSize());
		
		for(int i = q.getSize(); i > 0; i --) {
			Object o = q.deQueue();
			System.out.println(o);
		}
	}
}
