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
	
	public void addatindex(int item, int k) throws Exception {
		if( k == 0 ) {
			addfirst(item);
		}else if( k == size ) {
			addlast(item);
		}else {
			Node nn = new Node();
			nn.val = item;
			Node k_1th = GetNode(k-1);
			nn.next = k_1th.next;	
			k_1th.next = nn;
		}
	}
	
	private Node GetNode(int k) throws Exception {
		if( k<0 || k >= size ) {
			throw new Exception("Bklol k out of range hai");
		}
		Node temp = head;
		Node nn = new Node();
		for(int i=0; i < k; i++) {
			temp = temp.next;
		}
		return temp;
	}
	public void display() {
		Node temp = head;
		while (temp != null) {
		System.out.print(temp.val + "->");	
		temp = temp.next;
		}
		System.out.println(".");
	}
	
	public int getfirst() {
		return head.val;
	}
	
	public int getlast() {
		return tail.val;
	}
	
	public int getatindex( int k ) throws Exception {
		return GetNode(k).val;
	}
}
