package sampleQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;




class QueueTest {

	/**
	 * Tests for Queue.
	 */

	private static final String SOME_ITEM = "some-content";
	private Queue<String> q;
	private Queue<String> q2;

	
	@BeforeEach
	void init() {
		this.q = new Queue<String>();
		this.q2 = new Queue<String>(3);
	}


	@Test
	@Disabled
	@DisplayName("is instantiated with new Queue()")
	void isInstantiatedWithNew() {
		new Queue<>();
	}

	
	
	@Test
	@DisplayName("Verify Queue isEmpty when queue is initialized")
	void isEmptyShouldGiveTrueOnQueueInit() {
		assertTrue(q.isEmpty());
	}



	@Test
	@DisplayName("Verify Queue isEmpty when queue is non-empty")
	void isEmptyShouldGiveFalseOnQueueInit() {
		q.enqueue("aaaa");
		assertFalse(q.isEmpty());
	}



	@Test
	@DisplayName("test size method of Queue")
	public void testSize() {
		q.enqueue("aaaa");
		q.enqueue("bb");
		q.enqueue("bbb");
		assertEquals(3, q.size());
	}

	@Test
	@DisplayName("test length method of Queue")
	public void testLenghth() {
		int a = 0;
		q.enqueue("aaaa");
		q.enqueue("bb");
		q.enqueue("bbb");
		while (q.length() != 0) {
            q.dequeue();
            a = a + 1;
        }
        assertEquals(3, a);
	}

	@Test
	@DisplayName("test enqueue method of Queue")
	public void testOneEnqueue() {
		q.enqueue("aaaa");
		 assertEquals(q.peek(), "aaaa");
	}

	@Test
	@DisplayName("test enqueue method of Queue")
	public void testTwoEnqueue() {
		q.enqueue("aaaa");
		q.enqueue("bbbb");
		 assertEquals("aaaa", q.peek());
	}

	
	@Test
	@DisplayName("test dequeue method of Queue")
	public void testOneDequeue() {
		q.enqueue("aaaa");
		assertTrue("aaaa"==q.dequeue());
	}

	@Test
	@DisplayName("test peek method of Queue")
    public void testPeek() 
    {
        q.enqueue("aaaa");
        assertEquals("aaaa", q.peek() );
    }

    @Test
	@DisplayName("test toString method of Queue")
    public void testToSring() 
    {
        q.enqueue("aaaa");
        q.enqueue("bbbb");
        assertEquals("aaaa bbbb ", q.toString() );
    }

    @Test
	@DisplayName("test removeALl method of Queue")
    public void testRemoveAll() 
    {
        q.enqueue("aaaa");
        q.enqueue("bbbb");
        q.removeAll();
        assertTrue(q.isEmpty());
    }

    @Test
	@DisplayName("Test assert NoSuchElementException")
	void testNoSuchElementException_dequene() {

     NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            q.dequeue();
        });
    assertEquals("Queue underflow", exception.getMessage());
	}

    @Test
	@DisplayName("Test assert NoSuchElementException")
	void testNoSuchElementException_peek() {

     NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            q.peek();
        });
    assertEquals("Queue underflow", exception.getMessage());
	}

	@Test
	@DisplayName("test enqueue method of Queue failing test")
	public void testEnqueue_maxlenghth() {
		q2.enqueue("aaaa");
		q2.enqueue("bbbb");
		q2.enqueue("aaaa");
		q2.enqueue("bbbb");
		 assertEquals(3, q2.size());
	}

	// @Test
	// @DisplayName("test mian Queue")
 //    public void testMain() 
 //    {
 //    	q.main();
 //        assertEquals("aaaa bbbb ",  outContent.toString());
 //    }

	//Example of Wrong Test! 
	// @Test
	// @Disabled
	// @DisplayName("Verify Queue isEmpty returns false when queue is not empty")
	// void isEmptyShouldGiveFalseWhenQueueIsNotEmpty() {
	// 	this.q.enqueue(SOME_ITEM);
	// 	assertFalse(q.isEmpty());
	// }

	
}
