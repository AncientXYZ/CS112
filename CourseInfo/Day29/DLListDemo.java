class DLNode {
	boolean value;
	protected DLNode next;
	protected DLNode prev;
	
	public DLNode(boolean b) {
		value = b;
		next = null;
		prev = null;
	}
}

class DLList {
	DLNode head;
	DLNode tail;
	DLList() {
		head = null;
		tail = null;
	}
	public void add(boolean b) {
		if (head == null) { // and tail better be null
			head = new DLNode(b);
			tail = head;
		} else { // add to end
			DLNode newNode = new DLNode(b);
			DLNode oldTail = tail;
			tail = newNode; // step 1
			oldTail.next = newNode; // step 2
			newNode.prev = oldTail; // step 3
		}
	}
	public void printBackwards() {
		DLNode ptr = tail;
		while (ptr != null) {
			System.out.println(ptr.value);
			ptr = ptr.prev;
		}
	}
	public void printForwards() {
		printForwards(head);
	}
	private void printForwards(DLNode ptr) {
		if (ptr == null) { return; }
		System.out.println(ptr.value);
		printForwards(ptr.next);
	}
}



public class DLListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
