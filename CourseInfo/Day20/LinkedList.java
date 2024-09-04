class Node<TYPE> {
	TYPE value;
	Node<TYPE> next;

	Node(TYPE v) { value = v; }
}

class SLList<TYPE> {
	Node<TYPE> head = null; // points to head of our list.

	// Add a value to the front of our list.
	void addToFront(TYPE n) {
		Node<TYPE> newNode = new Node<>(n);
		newNode.next = head; // new head points to the old head...
		head = newNode; //...and the new Node becomes the new head
	}

}

public class LinkedList {

	public static void main(String[] args) {
		SLList<Integer> theList = new SLList<>();
		for(int i = 0; i < 10; i++) {
			theList.addToFront(i);
		}
		theList.print();
	}
} // end MyProgram