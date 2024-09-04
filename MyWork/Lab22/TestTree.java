/*********************************************************
 * filename: TestTree.java
 *
 * A file that builds a binary tree, fills it with
 *  integers read from a file, and does some operations
 *  on the tree, printing the results.
 *********************************************************/

import java.io.File;
import java.util.Scanner;


/** class Tree
 *
 * A binary tree data structure that stores TreeNodes.
 * Can:
 *	add new TreeNodes,
 *	sum all values in the tree,
 *	find minimum value in the tree,
 *	find total number of entries in the tree,
 *	find maximum depth of the tree.
 */
class Tree {
	/**
	 * class TreeNode - a private member class of Tree
	 * <p>
	 * A node in class Tree.
	 * Stores a value, and references to zero, one, or two children.
	 */
	private class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		TreeNode(int v) {
			value = v;
			left = null;
			right = null;
		}

		int value() {
			return value;
		}
	}

	//////
	////// Class members of Tree
	//////
	TreeNode root;

	//////
	////// Class methods
	//////
	public Tree() {
		root = null;
	}

	/**
	 * Add an int value to the tree
	 *
	 * @param input the int value to be added to the tree
	 */
	public void add(int input) {
		TreeNode n = new TreeNode(input);

		if (root == null) {
			root = n;
			return;
		}
		add(root, input);
	}

	private void add(TreeNode top, int v) {
		// Put the new node into the tree, in "sorted order".
		// Nodes are added "to the left" of nodes with greater values
		// and "to the right" of nodes with smaller values.
		//
		// 'top' should not be null
		if (v > top.value()) {
			if (top.right == null) {
				top.right = new TreeNode(v);
			} else {
				add(top.right, v);
			}
		} else {
			if (top.left == null) {
				top.left = new TreeNode(v);
			} else {
				add(top.left, v);
			}
		}
	}

	public int sum() {
		return sum(root);
	}

	private static int sum(TreeNode n) {
		if (n == null) {
			return 0;
		} else {
			return n.value() + sum(n.left) + sum(n.right);
		}
	}

	public int size() {
		return size(root);
	}

	private static int size(TreeNode n) {
		if (n == null) {
			return 0;
		} else {
			return 1 + size(n.left) + size(n.right);
		}
	}

	public int depth() {
		return depth(root);
	}

	private static int depth(TreeNode n) {
		if (n == null) {
			return 0;
		} else {
			int left = depth(n.left);
			int right = depth(n.right);
			if (left > right) {
				return left + 1;
			} else {
				return right + 1;
			}
		}
	}

	/**
	 * @return minimum value stored in the tree.
	 * <p>
	 * If the tree is empty, throw an Exception.
	 */
	public int min() throws Exception {
		if (root == null) {
			throw new Exception("TreeMin() called with null arg");
		}

		TreeNode current = root;
		while (current.left != null) {
			current = current.left;
		}
		return current.value;
	}
}

	public class TestTree {
		public static void main(String[] args) throws Exception {
			if (args.length < 1) {
				System.err.println("ERROR: need a filename");
				System.exit(0);
			}
			Tree myTree = new Tree();
			// STUDENTS FILL IN CODE TO READ INTS FROM A FILE WHOSE
			// FILENAME IS IN args[0] AND ADD THEM TO THE TREE.
			File file = new File(args[0]);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextInt()) {
				int num = scanner.nextInt();
				myTree.add(num);
			}

			System.out.println("Sum is " + myTree.sum());
			System.out.println("Min is " + myTree.min());
			System.out.println("Size is " + myTree.size());
			System.out.println("Depth is " + myTree.depth());
		}
	}