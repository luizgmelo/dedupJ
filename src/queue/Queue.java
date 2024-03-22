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