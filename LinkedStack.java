import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {
	private Node<T> head;
	private int index;

	public LinkedStack() {
		head = null;
		index = 0;
	}

	public void push(T newEntry) {
		if (head == null) {
			head = new Node<T>(newEntry);
			index++;
		} else {
			head = new Node<T>(newEntry, head);
			index++;
		}
	}

	public T pop() {
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			index--;
			Node<T> temp = head;
			head = head.getNext();
			return temp.getData();
		}
	}

	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		else{
			return head.getData();
		}
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void clear() {		
		head = null;
		index = 0;
	}
	
	public int getSize()
	{
		return index;
	}

}
