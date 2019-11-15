package com.hzh.AvlTree;



public class AvlTreeDome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 11, 7, 6, 8, 9 };  
		System.out.println("one");
		//创建一个 AVLTree对象
		AvlTree avlTree = new AvlTree();
		//添加结点
		for(int i=0; i < arr.length; i++) {
			avlTree.add(new Node(arr[i]));
		}
		System.out.println("中序遍历");
		avlTree.infixOrder();
		System.out.println("在平衡处理~~");
		System.out.println("树的高度=" + avlTree.getRoot().TreeHight()); //3
		System.out.println("树的左子树高度=" + avlTree.getRoot().leftHight()); // 2
		System.out.println("树的右子树高度=" + avlTree.getRoot().ringhtHight()); // 2
		System.out.println("当前的根结点=" + avlTree.getRoot());//8
		
	}

}
class AvlTree{
	private Node root;
	
	
	
	//添加节点
	public void add(Node node){
		if(root==null){
			root=node;
		}else{
			root.add(node);
		}
	}
	//获取根节点
	public  Node getRoot() {
		return root;
	}
	//中序遍历
	public void infixOrder() {
		if(root==null){
			System.out.println("空树");
		}else{
			root.infixOreder();
		}
	}

}

//创建节点
class Node {
	int val;
	Node left;
	Node right;

	public Node(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}
	//返回左子树的高度
	public int leftHight() {
		if (left == null) {
			return 0;
		}
		return left.TreeHight();
	}

	// 返回右子树的高度
	public int ringhtHight() {
		if (right == null) {
			return 0;
		}
		return right.TreeHight();
	}
	
	//返回当前树的高度
	public int TreeHight(){
		return Math.max(left==null?0:left.TreeHight(), right==null?0:right.TreeHight())+1;
	}
	//左旋转
	public void Leftrotate() {
		//创建一个新节点 并等于传入的节点
		Node newnode =new Node(val) ;
		//给新创建的节点添加子树 
	    newnode.left=left;
	    newnode.right=right.left;
	    //创建新的父节点
	    val=right.val;
	    //给新的父节点定义子树
	    left=newnode;
	    right=right.right;	
	}
	//右旋转
    public void Rightrotate() {
		// 创建一个新节点 并等于传入的节点
		Node newnode = new Node(val);
		// 给新创建的节点添加子树
		newnode.right = right;
		newnode.left = left.right;
		// 创建新的父节点
		val = left.val;
		// 给新的父节点定义子树
		left = left.left;
		right = newnode;
	}

	// 递归添加
	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (node.val < this.val) {
			if (this.left != null) {
				this.left.add(node);
			} else {
				this.left = node;
			}
		} else {
			if (this.right != null) {
				this.right.add(node);
			} else {
				this.right = node;
			}
		}
		//右子树高度>左子树高度 
		if (ringhtHight() - leftHight()>1) {// 左旋转
			// 右子树中的左子树高度大于右子树 应该先进行右旋转
			if (right!=null&&right.leftHight() > right.ringhtHight()) {
				right.Rightrotate();
				Leftrotate();
			} else {
				Leftrotate();
			}
                 return;
		}
		//右子树高度<左子树高度 
		if(leftHight()-ringhtHight()>1){//右旋转
			// 左子树中的右子树高度大于左子树 应该先进行左旋转
			if (left!=null&&left.ringhtHight() > left.leftHight()) {
				left.Leftrotate();
				Rightrotate();
			} else {
				Rightrotate();
			}
		}	
	}

	// 中序遍历
	public void infixOreder() {
		if (this.left != null) {
			this.left.infixOreder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOreder();
		}
	}

	// 寻找待删除节点
	public Node searchDel(int val) {
		if (this.val == val) {
			return this;
		}
		if (val < this.val) {
			if (this.left != null) {
				return this.left.searchDel(val);
			} else {
				return null;
			}
		} else {
			if (this.right != null) {
				return this.right.searchDel(val);
			} else {
				return null;
			}
		}
	}

	// 寻找待删除的父节点
	public Node searchParent(int value) {
		// 如果当前结点就是要删除的结点的父结点，就返回
		if ((this.left != null && this.left.val == value) || (this.right != null && this.right.val == value)) {
			return this;
		} else {
			// 如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
			if (value < this.val && this.left != null) {
				return this.left.searchParent(value); // 向左子树递归查找
			} else if (value >= this.val && this.right != null) {
				return this.right.searchParent(value); // 向右子树递归查找
			} else {
				return null; // 没有找到父结点
			}
		}

	}

}