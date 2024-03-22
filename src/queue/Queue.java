package queue;

public class Queue<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	
	public Queue() {
		
	}
	
	public Queue(T element) {
		Node<T> node = new Node<T>(element);
		this.head = node;
		this.tail = node;
		this.size = 1;
	}
	
	// Basic Operations: enqueue, dequeue, isEmpty
	
	public void enqueue(T element) {
		Node<T> node = new Node<T>(element);
		if (this.isEmpty()) {
			this.head = node;
			this.tail = node;
			this.size++;
			return;
		}
		this.tail.setNext(node);
		this.tail = this.tail.getNext();
		this.size++;
	}
	
	public T dequeue() {
		if (this.isEmpty()) {
			 return null;
		}
		
		Node<T> deleted = this.head;
		
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
			return deleted.getData();
		}
		
		this.head = this.head.getNext();
		this.size--;
		
		return deleted.getData();
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
}




class Node<T> {
	private T data;
	private Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
}