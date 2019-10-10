package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<? super E>> implements Tree<E> {

	private TreeNode<E> root;
    private int size;
    
    public BST(){
        root = null;
        size = 0;
    }

    @Override
    public void add(E element) {
        if(root==null) {
            root = new TreeNode<>(element);
            size++;
        }
        add(element, root);
    }
    
    private void add(E element, TreeNode<E> node){
        int c = element.compareTo(node.data);
        if(c==0) return;
        if(c<0 && !node.hasLeft()){
            node.left = new TreeNode<>(element);
            size++;
        }else if(c>0 && !node.hasRight()){
            node.right = new TreeNode<>(element);
            size++;
        }else if(c<0){
            add(element, node.left);
        }else if(c>0){
            add(element, node.right);
        }
    }

    @Override
    public boolean contains(E element) {
    	if (root == null)
			return false;
		return contains(element, root);
    }
    
    private boolean contains(E element, TreeNode<E> node) {
		int c = element.compareTo(node.data);
		if (c == 0) {
			return true;
		} else if (c < 0 && node.hasLeft()) {
			return contains(element, node.left);
		} else if (c > 0 && node.hasRight()) {
			return contains(element, node.right);
		}
		return false;
	}

    @Override
    public boolean remove(E element) {
       if(contains(element)) {
    	   root = remove(element, root);
    	   return true;
       }
       return false;
    }
    

	private TreeNode<E> remove(E element, TreeNode<E> node){
    	if(node == null) {
    		return node;
    	}
    	int c = element.compareTo(node.data);
    	if (c < 0) {
    		node.left = remove(element, node.left);
    	}
    	else if(c > 0) {
    		node.right = remove(element, node.right);
    	}else {
    		if(!node.hasLeft()) {
    			return node.right;
    		}else if(!node.hasRight()) {
    			return node.left;
    		}
    		node.data = successor(node.data);
    		node.right = remove(node.data, node.right);
    	}
    	return node;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
    	root = null;
		size = 0;   
		}

    @Override
    public String inOrder() {
        return inOrder(root);
    }
    
    private String inOrder(TreeNode<E> node){
        if(node==null) return "";
        return inOrder(node.left) + node + inOrder(node.right);
    }

    @Override
    public String preOrder() {
    	return preOrder(root);    
    }
    
    private String preOrder(TreeNode<E> node) {
		if (node == null)
			return "";
		return node + preOrder(node.left) + preOrder(node.right);
	}

    @Override
    public String postOrder() {
    	return postOrder(root);
    }
    
    private String postOrder(TreeNode<E> node) {
		if (node == null)
			return "";
		return postOrder(node.left) + postOrder(node.right) + node;
	}

    @Override
    public String breadthFirst() {
    	if(root == null) return null;
		String levels = "";
		Queue<TreeNode<E>> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			if(queue.peek().left != null) {
				queue.add(queue.peek().left);
			}
			if(queue.peek().right != null) {
				queue.add(queue.peek().right);
			}
			levels = levels + queue.poll();
			
		}
		
		return levels;
	}
    

    @Override
    public E predecessor(E element) {
       if (root == null)
			return null;
		return predecessor(element, root);
    }
    
    private E predecessor(E element, TreeNode<E> node) {
		int c = element.compareTo(node.data);
		if (c == 0) {
			if(node.hasLeft()) {
				node = node.left;
				while(node.hasRight()) {
					node = node.right;
				}
				return node.data;
			}
			else {
				return null;
			}
		} else if (c < 0 && node.hasLeft()) {
			return predecessor(element, node.left);
		} else if (c > 0 && node.hasRight()) {
			return predecessor(element, node.right);
		}
		return null;
	}


    @Override
    public E successor(E element) {
    	if (root == null)
			return null;
		return successor(element, root);
    }
    
    private E successor(E element, TreeNode<E> node) {
		int c = element.compareTo(node.data);
		if (c == 0) {
			if(node.hasRight()) {
				node = node.right;
				while(node.hasLeft()) {
					node = node.left;
				}
				return node.data;
			}
			else {
				return null;
			}
		} else if (c < 0 && node.hasLeft()) {
			return successor(element, node.left);
		} else if (c > 0 && node.hasRight()) {
			return successor(element, node.right);
		}
		return null;
	}


    @Override
    public E getLargest() {
       if (root == null) {
			return null;
		} else {
			TreeNode<E> node = root;
			while (node.hasRight()) {
				node = node.right;
			}
			return node.data;
		}
    }

    @Override
    public E getLowest() {
    	if (root == null) {
			return null;
		} else {
			TreeNode<E> node = root;
			while (node.hasLeft()) {
				node = node.left;
			}
			return node.data;
		}
    }

    @Override
    public int numLeaves() {
    	int leaves = 0;
		return leaves + numLeaves(root);
    }
    
    private int numLeaves(TreeNode<E> node) {
		int leaves = 0;
		if (node == null)
			return leaves;
		if(node.isLeaf()) leaves++;
		return leaves + numLeaves(node.left) + numLeaves(node.right);
	}


    @Override
    public int size() {
        return size;
    }

    @Override
    public E getSibling(E element) {
    	E data = root.data;
		if (data.compareTo(element) == 0 || root == null) {
			return null;
		}
		return getSibling(element, root, null);
    }
    
    private E getSibling(E element, TreeNode<E> node, TreeNode<E> parent) {
		int c = element.compareTo(node.data);
		if (c == 0) {
			if(parent.hasLeft() && parent.hasRight()) {
				if(parent.left.data.compareTo(element) == 0) {
					return parent.right.data;
				} else if (parent.right.data.compareTo(element) == 0) {
					return parent.left.data;
				}
			}
			return null;
		} else if (c < 0 && node.hasLeft()) {
			return getSibling(element, node.left, node);
		} else if (c > 0 && node.hasRight()) {
			return getSibling(element, node.right, node);
		}
		return null;
	}

    @Override
    public E getParent(E element) {
    	E data = root.data;
		if (data.compareTo(element) == 0 || root == null) {
			return null;
		}
		return getParent(element, root, null);
    }
    
    private E getParent(E element, TreeNode<E> node, TreeNode<E> parent) {
		int c = element.compareTo(node.data);
		if (c == 0) {
			return parent.data;
		} else if (c < 0 && node.hasLeft()) {
			return getParent(element, node.left, node);
		} else if (c > 0 && node.hasRight()) {
			return getParent(element, node.right, node);
		}
		return null;
	}
    
}
