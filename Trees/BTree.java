package Trees;

import javax.crypto.spec.RC2ParameterSpec;

@SuppressWarnings("all")
class Node {

	public Comparable data;
	public Node left, right;

	public Node(Comparable data) {
		this(data, null, null);
	}

	public Node(Comparable data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

@SuppressWarnings("all")
class BTree {
	private Node root;

	public BTree() {
		root = null;
	}

	public void add(Comparable key) {
		Node rrent = root, parent = null;
		while (rrent != null) {
			if (key.compareTo(rrent.data) < 0) {
				parent = rrent;
				rrent = rrent.left;
			}

			else {
				parent = rrent;
				rrent = rrent.right;
			}
		}

		if (parent == null)
			root = new Node(key);

		else {
			if (key.compareTo(parent.data) < 0)
				parent.left = new Node(key);

			else
				parent.right = new Node(key);
		}
	}

	public boolean delete(Comparable key) {
		if (root == null)
			return false;
		Node rrent = root;
		Node parent = root;
		boolean right = true;
		// searching for the node to be deleted
		while (key.compareTo(rrent.data) != 0) {
			if (key.compareTo(rrent.data) < 0) {
				right = false;
				parent = rrent;
				rrent = rrent.left;
			} else {
				right = true;
				parent = rrent;
				rrent = rrent.right;
			}
			if (rrent == null)
				return false;
		}

		Node substitute = null;
		// case 1: Node to be deleted has no children
		if (rrent.left == null && rrent.right == null)
			substitute = null;

		// case 2: Node to be deleted has one child
		else if (rrent.left == null)
			substitute = rrent.right;
		else if (rrent.right == null)
			substitute = rrent.left;
		else // case 3: Node to be deleted has two children
		{
			Node successor = rrent.right;
			Node successorParent = rrent;
			// searching for the inorder successor of the node to be deleted
			while (successor.left != null) {
				successorParent = successor;
				successor = successor.left;
			}
			substitute = successor;
			if (successorParent == rrent) {
				if (successor.right == null)
					successorParent.right = null;
				else
					successorParent.right = successor.right;
			} else {
				if (successor.right == null)
					successorParent.left = null;
				else
					successorParent.left = successor.right;
			}
			successor.right = rrent.right;
			successor.left = rrent.left;
			substitute = successor;
		} // case 3 done
		if (rrent == root) // Replacing the deleted node
			root = substitute;
		else if (right)
			parent.right = substitute;
		else
			parent.left = substitute;
		return true;

	}

	public void displayTree() {
		java.util.Stack<Node> globalStack = new java.util.Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
				"......................................................");
		while (isRowEmpty == false) {
			java.util.Stack<Node> localStack = new java.util.Stack<Node>();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');

			while (globalStack.isEmpty() == false) {
				Node temp = globalStack.pop();
				if (temp != null) {
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if (temp.left != null ||
							temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		} // end while isRowEmpty is false
		System.out.println(
				"......................................................");
	}

	// Ex93
	public Comparable maxKey() {
		Node rr = root;
		while (rr.right != null)
			rr = rr.right;
		return rr.data;
	}

	// EX94
	public int findMax() {
		return findMax(root);
	}

	private int findMax(Node n) {
		if (n == null)
			return -1;
		int maxLeft = findMax(n.left);
		int maxRight = findMax(n.right);
		return Math.max(((int) n.data), Math.max(maxLeft, maxRight));
	}

	// EX95
	public int size() {
		return size(root);
	}

	private int size(Node r) {
		if (r == null)
			return 0;
		return size(r.right) + size(r.left) + 1;
	}

	public int numLeaves() {
		return numLeaves(root);
	}

	private int numLeaves(Node r) {
		if (r == null)
			return 0;
		if (r.right == null && r.left == null)
			return 1;
		else
			return numLeaves(r.left) + numLeaves(r.right);
	}

	public int sum() {
		return sum(root);
	}

	private int sum(Node r) {
		if (r == null)
			return 0;
		else {
			int totalSum = (int) r.data;
			totalSum += sum(r.left);
			totalSum += sum(r.right);
			return totalSum;
		}
	}

	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(Node r) {
		if (r == null)
			return true;
		if ((r.right == null && r.left != null) || (r.left == null && r.right != null))
			return false;
		return isBST(r.left) && isBST(r.right);
	}

	public int numLeftChildNodes() {
		return numLeftChildNodes(root);
	}

	private int numLeftChildNodes(Node r) {
		if (r == null)
			return 0;
		if (r.left != null && r.right == null)
			return 1 + numLeftChildNodes(r.left);
		return numLeftChildNodes(r.left) + numLeftChildNodes(r.right);
	}

	public int countOcr(Comparable key){
		return countOcr(root,key);
	}

	private int countOcr(Node r, Comparable x) {
		if (r == null)
			return 0;
		if (x.compareTo(r.data) == 0)
			return countOcr(r.right, x) + countOcr(r.left, x) + 1;
		else
			return countOcr(r.right, x) + countOcr(r.left, x);
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node rrent) {
		if (rrent != null) {
			mirror(rrent.left);
			mirror(rrent.right);
			Node temp = rrent.left;
			rrent.left = rrent.right;
			rrent.right = temp;
		}
	}

	public String oddNodes() {
		return oddNodes(root);
	}

	private String oddNodes(Node r) {
		if (r == null)
			return "";
		return ((int) r.data % 2 != 0 ? (r.data + " ") : "") + oddNodes(r.left) + oddNodes(r.right);
	}

	// EX96
	public int level(Comparable key) {
		return level(root, key);
	}

	public int level(Node r, Comparable key) {
		if (r == null)
			return -1;
		if (r.data.compareTo(key) == 0)
			return 0;
		int leftDepth = level(r.left, key);
		if (leftDepth != -1)
			return 1 + leftDepth;
		int rightDepth = level(r.right, key);
		if (rightDepth != -1)
			return 1 + rightDepth;
		return -1;
	}

	// EX97
	public BTree doubleValues() {
		BTree t2 = new BTree();
		doubleValuesHelper(this.root, t2);
		return t2;
	}

	private void doubleValuesHelper(Node cur, BTree t2) {
		if (cur == null)
			return;
		else {
			t2.add(2 * (int) cur.data);
			doubleValuesHelper(cur.left, t2);
			doubleValuesHelper(cur.right, t2);
		}
	}

	// Ex98
	public boolean equal(BTree t) {
		return equal(root, t.root);
	}

	private boolean equal(Node r, Node r2) {
		if (r == null && r2 == null)
			return true;
		else if (r == null || r2 == null)
			return false;
		else
			return (r.data.compareTo(r2.data) == 0) &&
					equal(r.left, r2.left) &&
					equal(r.right, r2.right);
	}

}