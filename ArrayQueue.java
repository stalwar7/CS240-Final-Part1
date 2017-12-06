public class ArrayQueue<T> implements Queue2Interface<T> {

	private T[] queue;
	private int frontIndex;
	private int backIndex;
	//private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayQueue(int initialCapacity) {
		@SuppressWarnings("unchecked")
		T[]	tempQueue = (T[])new Object[initialCapacity + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
		//initialized = true;
	} 
	
	public boolean enqueue(T newEntry) {
		if(frontIndex == ((backIndex + 2) % queue.length)) {
			return false;
		}
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
		return true;
	} // end method enqueue

	public T dequeue() {
		if (isEmpty()) {
			throw new Error("Empty Queue");
		} else {
			T frontItem = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return frontItem;
		}
	} 

	public T getFront() {
		if (isEmpty()) {
			throw new Error("Empty Queue");
		} else {
			return queue[frontIndex];
		} 
	} 
	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % queue.length);
	}  

	public void clear() {
		if (!isEmpty()) {
			dequeue();
		}
		frontIndex = 0;
		backIndex = queue.length - 1;
	} 
	
	private void ensureCapacity() {
		if (frontIndex == ((backIndex + 2) % queue.length)) {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for (int index = 0; index < oldSize - 1; index++) {
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			backIndex = oldSize - 2;
		} 
	} 
	
} 