public class LinkedList<T> implements ListInterface<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public LinkedList() {
		head = null;
		tail = null;
	}

	public void add(T item) {
		if (isEmpty()) {
			head = new Node<T>(item, tail);
			tail = head;
			size++;
		} else {
			Node<T> node = new Node<T>(item, tail);
			Node<T> temp = tail;
			temp.setNext(node);
			tail = node;
			size++;
		}
	}

	public void add(int position, T item) {
		Node<T> node = new Node<T>(item);
		if (position == 0) {
			head = node;
			size++;
		} else {
			Node<T> prev = tail;
			Node<T> newNode = new Node<T>(item, prev.getNext());
			prev.setNext(newNode);
			size++;
		}
	}

	public T remove(int position) {
		if (position < 0)
			throw new IndexOutOfBoundsException();
		T result = null;
		if (position == 0) {
			result = head.getData();
			head = head.getNext();
			size--;
		} else {
			Node<T> current = head;
			while (position >= 0) {
				current = current.getNext(); // gets the second last element
			}
			result = current.getData();
			tail = current;
			size--;
		}
		return result;
	}

	public T view(int position) {
		if (position < 0)
			throw new IndexOutOfBoundsException();
		int index = 1;
		Node<T> result = head;
		while (index < position) {
			index++;
			result = result.getNext();
		}
		return result.getData();
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void clear() {
		head = null;
	}

	public boolean contains(T item) {
		Node<T> node = head;
		if (node.getData().equals(item))
			return true;
		while (node.getNext() != null) {
			node = node.getNext();
			if (node.getData().equals(item)) {
				return true;
			}
		}
		return false;
	}

	public void replace(int position, T item) {
		Node<T> temp = head;
		int index = 1;
		while (index < position) {
			temp = temp.getNext();
			index++;
		}
		temp.setData(item);
	}

	public int size() {
		return size;
	}

}
