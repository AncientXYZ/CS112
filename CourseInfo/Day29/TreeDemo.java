class IntNode {
	int value;
	IntNode left;
	IntNode right;

	IntNode(int v) {
		value = v;
		left = null;
		right = null;
	}
}

class IntTree2 {
	IntNode root;
	IntTree2() { root = null; }
	
	public void add(int i) {
		if (root == null) {
			root = new IntNode(i);
		} else {
			IntNode ptr = root;
			while (true) {
				if (i < ptr.value) {
					if (ptr.left != null) {
						ptr = ptr.left;
					} else {
						ptr.left = new IntNode(i);
						break;
					}
				} else if (i > ptr.value) {
					if (ptr.right != null) {
						ptr = ptr.right;
					} else {
						ptr.right = new IntNode(i);
						break;
					}
				} // else we already have 'i' in the tree
			}
		}
	}
}

public class TreeDemo {
	static int method(int n) {
		if (n == 1) { return 1; }
		return (method(n-1) + 1);
	}
	public static void main(String[] args) {
		System.out.println(method(0));

	}

}
