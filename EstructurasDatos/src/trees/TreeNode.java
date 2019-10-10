package trees;

public class TreeNode<E> {
	
	public E data;
	public TreeNode<E> left;
	public TreeNode<E> right;
	
	public TreeNode() {
		data = null;
		left = null;
		right = null;
	}
	
	public TreeNode(E data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	public boolean hasRight() {
		return right != null;
	}
	
	public boolean hasLeft() {
		return left != null;
	}

	@Override
	public String toString() {
		return data + " ";
	}
}
