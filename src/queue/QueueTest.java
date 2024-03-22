package queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {
	
	@Test
	void testQueue() {
		Queue<Integer> queue = new Queue<Integer>();
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void testQueueT() {
		Queue<Integer> queue = new Queue<Integer>(20);
		assertFalse(queue.isEmpty());
	}
	
	@Test
	void testEnqueue() {
		Queue<Integer> queue = new Queue<Integer>();
		assertTrue(queue.isEmpty());
		queue.enqueue(10);
		assertFalse(queue.isEmpty());
	}
	
	@Test
	void testEnqueueWhenIsNotEmpty() {
		Queue<Integer> queue = new Queue<Integer>(20);
		assertFalse(queue.isEmpty());
		queue.enqueue(33);
		assertFalse(queue.isEmpty());
	}
	
	@Test
	void testDequeue() {
		Queue<Integer> queue = new Queue<Integer>(20);
		assertFalse(queue.isEmpty());
		int x = queue.dequeue();
		assertEquals(20, x);
		assertTrue(queue.isEmpty());
		
		queue.enqueue(10);
		queue.enqueue(33);
		int y = queue.dequeue();
		assertEquals(10, y);
		int z = queue.dequeue();
		assertEquals(33, z);
	}
	
	@Test
	void testFIFO() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(20);
		queue.enqueue(10);
		int first = queue.dequeue();
		assertEquals(20, first);
		int second = queue.dequeue();
		assertEquals(10, second);
		assertTrue(queue.isEmpty());
	}
	

}
