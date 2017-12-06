public class ArrayQueue<T> implements Queue2Interface<T> {

	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	} // end default constructor
	
	public ArrayQueue(int initialCapacity) {
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[]	tempQueue = (T[])new Object[initialCapacity + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
		initialized = true;
	} // end constructor
	
	public boolean enqueue(T newEntry) {
		checkInitialization();
		if(frontIndex == ((backIndex + 2) % queue.length)) {
			return false;
		}
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
		return true;
	} // end method enqueue

	public T dequeue() {
		checkInitialization();
		if (isEmpty()) {
			throw new Error("Empty Queue");
		} else {
			T frontItem = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return frontItem;
		} // end if
	} // end dequeue

	public T getFront() {
		checkInitialization();	
		if (isEmpty()) {
			throw new Error("Empty Queue");
		} else {
			return queue[frontIndex];
		} // end if
	} // end getFront

	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % queue.length);
	}  // end isEmpty

	public void clear() {
		if (!isEmpty()) {
			dequeue();
		} // end if 
		frontIndex = 0;
		backIndex = queue.length - 1;
	} // end clear
	
	private void checkCapacity(int capacity) {
		if (capacity > DEFAULT_CAPACITY) 
			throw new IllegalStateException("Attempt to cre"
					+ "ate a bag exeeds allowed max of " + DEFAULT_CAPACITY);
	} // end checkCapacity
	
	private void checkInitialization() {
		if (!initialized) 
			throw new SecurityException("ArrayBag is not initialized properly.");
	} // end checkInitialization
	
	private void ensureCapacity() {
		if (frontIndex == ((backIndex + 2) % queue.length)) {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			checkCapacity(newSize);
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for (int index = 0; index < oldSize - 1; index++) {
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			} // end for
			frontIndex = 0;
			backIndex = oldSize - 2;
		} // end if 
	} // end ensureCapacity
	
} // end ArrayQueue