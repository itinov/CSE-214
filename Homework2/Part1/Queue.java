package Homework2.Part1;

/* Queue class */
public class Queue<Friend> {
	
	// variables
	private Node<Friend> front;
	private Node<Friend> back;
	private int size;

	/* Node class */
	private static class Node<Friend> {
		private Friend item;
		private Node<Friend> link;

		/* Node Constructor that accepts Friend item paramater*/
		public Node(Friend item) {
			this.item = item;
			link = null;
		}
	} // end Node Class 

	/* Queue Constructor */
	public Queue() {
		front = null;
		back = null;
		size = 0;
	}
	
	/* enqueue method that was inspired by the lecture notes */
	public void enqueue(Friend item) {
		Node<Friend> temp = back;
		back = new Node<Friend>(item);
		back.link = null;
		if(isEmpty())
			front = back;
		else
			temp.link = back;
		size++;
	}

	/* dequeue method that was inspired by the lecture notes */
	public Friend dequeue() {
		Friend item = front.item;
		front = front.link;
		size--;
		return item;
	}
	
	/* isEmpty method to tell if the queue is empty or not */
	public boolean isEmpty() {
		return size() <= 0;
	}
	
	/* size method that returns the size of the queue */
	public int size() {
		return size;
	}
}