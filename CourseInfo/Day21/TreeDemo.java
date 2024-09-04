class BinaryTreeNode {
	String value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(String s) {
		value = s;
		left = null;
		right = null;
	}
}

class BinaryTree {
	private BinaryTreeNode root = null;

	// This public method adds a new node to
	// our tree, starting at root.
	public void add(String s) {
		if (root == null) {
			root = new BinaryTreeNode(s);
			return;
		}
		
		add(root, s);
	}

	// This private helper method is recursive.
	// It might call itself to add a node to the tree.
	private void add(BinaryTreeNode ptr, String s) {

		// Where do we add the new Node?
		// Add to the left or right at random!
		boolean useLeft = (Math.random() > 0.5);

		if (useLeft) {
			if (ptr.left == null) {
				ptr.left = new BinaryTreeNode(s); // base case
			} else {
				add(ptr.left, s); // recursive case
			}
		} else {
			if (ptr.right == null) {
				ptr.right = new BinaryTreeNode(s);
			} else {
				add(ptr.right, s);
			}
		}
	}
}

public class TreeDemo {

	public static void main(String[] args) {
		// Make a tree and add 50 Strings to it.
		BinaryTree theTree = new BinaryTree();
		for (int count = 0; count < 50; count++) {
			theTree.add("nodeNum:" + count);
		}
		// Can you search the tree for a particular String?
	}

}
