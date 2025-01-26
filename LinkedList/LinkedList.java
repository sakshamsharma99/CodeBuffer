package Lec1;

public class LinkedList {
	public class Node {
		int val;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;
	
	public void addfirst(int item) {
		Node nn = new Node();
		nn.val = item;
		if(size == 0) {
			head = nn;
			tail = nn;
			size++;
		}else {
			nn.next = head;
			head = nn;
			size++;
		}
	}
	
	public void addlast(int item) {
		if(size == 0) {
			addfirst(item);
		}else {
			Node nn = new Node();
			nn.val = item;
			tail.next = nn;
			tail = nn;
			size++;
		}
	}
	public void display() {
		Node temp = head;
		while (temp != null) {
		System.out.print(temp.val + "->");	
		temp = temp.next;
		}
		System.out.print(".");
	}
}
