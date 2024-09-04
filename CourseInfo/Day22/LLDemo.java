class IntNode {
	int value;
	IntNode next;
	
	public IntNode(int v) {
		value = v;
		next = null;
	}
}
class LList {
	private IntNode head = null;
	
	public void add(int n) {
		if (head == null) {
			head = new IntNode(n);
			return;
		}
		
		// Otherwise head is not null.
		if (n < head.value) {
			IntNode oldHead = head;
			head = new IntNode(n);
			head.next = oldHead;
			return;
		}
		
		// Where do we add this new number?
		IntNode ptr = head;
		while (ptr.next != null && ptr.next.value < n) {
			ptr = ptr.next;
		}
		IntNode newNode = new IntNode(n);
		newNode.next = ptr.next;
		ptr.next = newNode;
	}
	
	public void print() {
		IntNode ptr = head;
		while (ptr != null) {
			System.out.print(ptr.value + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
}

public class LLDemo {

	public static void main(String[] args) {
		LList theList = new LList();
		for (int count = 0; count < 35; count++) {
			theList.add( (int) (1000*Math.random()) );
			// theList.print();
		}
		theList.print();
	}

}
