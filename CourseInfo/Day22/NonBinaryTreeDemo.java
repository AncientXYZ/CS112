import java.util.ArrayList;

class NonBinaryNode {
	int value; // store a Card value
	String suit;
	
	ArrayList<NonBinaryNode> myChildren;
	
	public NonBinaryNode(int v, String s) {
		value = v;
		suit = s;
		myChildren = new ArrayList<>();
	}
	
	public String toString() {
		return "" + value + suit.toUpperCase().substring(0,1);
	}

}

class NonBinaryTree {
	private NonBinaryNode root = null;
	
	// Add a new node to this tree.
	public void add(int v, String s) {
		 if (root == null) {
			 root = new NonBinaryNode(v, s);
			 return;
		 }
		add(root, v, s);
	}

	// Recursive "helper" function to add a new node
	// to this tree.
	private void add (NonBinaryNode ptr, int v, String s) {
		// Allow a max of 4 children per node.
		 if (ptr.myChildren.size() < 4) {
			 ptr.myChildren.add(new NonBinaryNode(v, s));
		 } else {
			 // If I have 4 children already, pick one of my
			 // children at random and add the new node to
			 // them or their children.
			 final int indx = (int) (4 * Math.random());
			 add(ptr.myChildren.get(indx), v, s); // recursive!
		 }
	}
	public void print() {
		print(root, 0);
	}
	private void print(NonBinaryNode ptr, int indent) {
		if (ptr == null) { return; }
		System.out.print(".".repeat(indent));
		System.out.println(ptr);
		for (NonBinaryNode p2 : ptr.myChildren) {
			print(p2, indent+1);
		}
	}

}

public class NonBinaryTreeDemo {

	public static void main(String[] args) {
		// Build a tree and add 52 cards to it.
		NonBinaryTree tree = new NonBinaryTree();
		String[] suits = {"S", "C", "H", "D"};
		for (int i = 2; i <= 14; i++) {
			for (String s : suits) {
				tree.add(i, s);
			}
		}
		// Can you print out the contents of the tree?
		tree.print();
	}

}
