
public class Node<T> {
	private T data;
	private Node<T> next;

	public Node(T entry) {
		this.data = entry;
	}

	public Node(T entry, Node<T> ahead) {
		this.data = entry;
		this.next = ahead;
	}

	public T getData() {
		return data;
	}

	public void setData(T entry) {
		data = entry;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> ahead) {
		next = ahead;
	}

}
