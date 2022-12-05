public class SymbolTable<Key extends Comparable<Key>, value {
	private Node root;
	private boolean isRed(Node h);
	private Node rotateLeft(Node h);
	private Node rotateRight(Node h);
	private void flipColors(Node h);
	final boolean BLACK = false;
	final boolean RED = true;

	public SymbolTable() {
		
	}
	
	public void put(Key k, Value v) { //need second method because we need to fix links
		root = put(root, k, v);
		root.color = BLACK; //make 
	}
	
	private Node put(Node h, Key k, Value v) {
		if (h == null) {
			return new Node(k, v); //if nothing there, attach
		}
		
		int comp = k.compareTo(x.key);
		if (comp == 0) { //if same
			return null;
		} else if (comp < 0) { //if less than
			h.left.add();
			h.left = put(h.left, k, v); //search left tree
			return h; //go back up and fix link
		} else if (comp > 0) { //if greater than
			h.right.add();
			h.right = put(h.right, k, v);
			return h;			
		}
	}
	
	public void fixUp(Node h) {
		if (isRed(h.right) && !isRed(h.left)) {//fix right leaning red
			h = rotateLeft(h);
		}
		if (isRed(h.left) && isRed(h.left.left)) {
			
		}
		if (isRed(h.right) && isRed(h.right)) {
			
		}
	}
	
	private Node fixUp() {
		
	}
	
	private Node max (Node x) {
		while (x.right != null) {//as long as there is a child
			x = x.right; //search right child
		}
		return x; //return the childless (biggest) node
	}
	
	private Node min (Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	public void deleteMin(Node x) {
		return min(x).k;
	}
	
	public void delete(Key k) {
		root = delete(root, k);
	}
	
	private void delete(Node x, Key k) { //returns a tree
		if (x == null) return null;
		
		int cmp = k.compareTo(x.key);
		if (cmp == 0) { //if found key
			if (x.right == null) return x.left; //search other child
			if (x.left == null) return x.right; 
			Node temp = x;
			x = min(t.right); // x becomes the min of the right link
			x.right = deleteMin(t.right); // make x.right the right link of the min
			
		} else if (cmp < 0) {
			x.left = delete(x.left, k); //x.left becomes the tree with k deleted
		} else if (comp > 0) {
			x.right = delte(x.right, k);
		}
		
		return delete(temp);
		
	}
	
	//public Node floor(Node x) { //greatest node that is less
		
	//}

	
	//public Node ceiling(Node x) { //smallest node that is greater
	
	//}
	
	public Key select(int i) { //the kth smallest key (in the whole tree)
		
		return select(root, i);
	
	}
	
	private Node select(Node x, int i) {
		if (x == null) return null;
		
		int s = size(x.left); //keys less than x + 1
		if (s == i) {
			return x.k;
		} else if (s < i) { //if node size is less than, search right
			return select(x.right, i-s-1); //don't have to satisfy parent.left, since we are subtracting it (and -1 for initial root)
		} else if (s > k) { //if node size is greater than, search left
			return select(x.left, i);
		}
	}
	
	//public int rank(Key k) { //reverse of select
		//return rank(root);
	//}
	
	private Node rank() {
		
	}
	
	private int size(Node x) { //number of nodes less than current node?
		return x.size;
		
	}
	
	private class Node implements Comparable<Node> {
		public Key k; // fields from the innerclass are public throughout the file
		public Value v;
		public Node parent;
		public int size;
		
		public Node(Key k, Value v) {
			this.key = k;
			this.value = v;
		}
		
		public int compareTo(Node that) {
			return this.k.compareTo(that.k);
		}
		
		public void add() {
			size += 1;
		}
	}
	
	public static void main(String[] args) {
		SymbolTable test = new SymbolTable();
		test.put(s, 1);
		test.put(e, 2);
		test.put(x, 3);
	}
}