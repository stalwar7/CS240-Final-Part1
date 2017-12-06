import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class LinkedDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {

	private int size;
	private DNode<K,V> head;
	
	public LinkedDictionary()
	{
		head = null;
		size = 0;
	}
	public V add(K key, V value) {
		if (head == null) 
		{
			DNode<K, V> newNode = new DNode<K, V>(key, value);
			head = newNode;
		}
		else if (key.compareTo(head.getKey()) < 0) 
		{
			DNode<K, V> newNode = new DNode<K, V>(key, value, head);
			head = newNode;
		}
		else
		{
			DNode<K, V> temp = head;
			
			while (temp.getNext() != null && key.compareTo(temp.getKey()) > 0) 
			{
				temp = temp.getNext();
			}
			
			if (key.compareTo(temp.getKey()) == 0) 
			{
				V thisValue = temp.getValue();
				temp.setValue(value);
				return thisValue;
			}
			else if (temp.getNext() == null && key.compareTo(temp.getKey()) > 0) 
			{
				DNode<K, V> newNode = new DNode<K, V>(key, value);
				temp.setNext(newNode);
			}
			else 
			{
				temp = head;
			
				while (temp.getNext() != null && key.compareTo(temp.getNext().getKey()) > 0) 
				{
					temp = temp.getNext();
				}
				
				DNode<K, V> newNode = new DNode<K, V>(key, value);
				DNode<K, V> temp2 = temp.getNext();
				temp.setNext(newNode);
				newNode.setNext(temp2);
			}
		}
		
		return null;
	}

	
	public V remove(K key) {
		if (key.equals(head.getKey())) //If the entry to be removed is the head, reset the head
		{
			V val = head.getValue();
			head = head.getNext();			
			return val;
		}
		else
		{
			DNode<K, V> temp = head;
			
			while (temp.getNext() != null && !key.equals(temp.getNext().getKey())) 
			{
				temp = temp.getNext();
			}
			
			if (temp.getNext() == null) 
			{
				return null;
			}
			else if (temp.getNext().getNext() == null) 
			{
				V val = temp.getNext().getValue();
				temp.setNext(null);
				return val;
			}
			else 
			{
				V val = temp.getNext().getValue();
				temp.setNext(temp.getNext().getNext());
				return val;
			}
		}
	}

	
	public V getValue(K key) {
		DNode<K,V> temp = head;
		while (temp.getNext() != null) {
			if (temp.getKey() == key)
				return temp.value;
			temp = temp.getNext();
		}
		return null;
	}

	
	public boolean contains(K key) {
		boolean result = false;
		DNode<K,V> temp = head;
		if(temp.getKey().equals(key))
			result = true;
		while (temp.next != null) {
			if (temp.key == key)
				result = true;
			temp = temp.next;
		}
		return result;
	}

	
	public Iterator<K> getKeyIterator() {
		List<K> iter = new ArrayList<K>();
		DNode<K,V> temp = head;
		iter.add(temp.getKey());
		while (temp.getNext() != null) {
			iter.add(temp.getKey());
			temp = temp.getNext();
		}
		return iter.iterator();
	}
	
	public Iterator<V> getValueIterator() {
		List<V> iter = new ArrayList<V>();
		DNode<K,V> temp = head;
		iter.add(temp.getValue());
		while (temp.getNext() != null) {
			iter.add(temp.getValue());
			temp = temp.getNext();
		}
		return iter.iterator();
	}
	
	public boolean isEmpty() {
		return (head == null);
	}

	
	public int getSize() {
		return size;
	}

	
	public void clear() {
		head = null;
	}
	public class DNode<K, V> {
		private K key;
		private V value;
		private DNode<K, V> next;

		public DNode(K key, V value, DNode<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public DNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public DNode<K, V> getNext() {
			return next;
		}

		public void setKey(K newKey) {
			key = newKey;
		}

		public void setValue(V newValue) {
			value = newValue;
		}

		public void setNext(DNode<K, V> nextNode) {
			next = nextNode;
		}

	}

}
