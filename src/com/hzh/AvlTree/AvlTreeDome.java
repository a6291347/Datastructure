package com.hzh.AvlTree;



public class AvlTreeDome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 11, 7, 6, 8, 9 };  
		System.out.println("one");
		//����һ�� AVLTree����
		AvlTree avlTree = new AvlTree();
		//��ӽ��
		for(int i=0; i < arr.length; i++) {
			avlTree.add(new Node(arr[i]));
		}
		System.out.println("�������");
		avlTree.infixOrder();
		System.out.println("��ƽ�⴦��~~");
		System.out.println("���ĸ߶�=" + avlTree.getRoot().TreeHight()); //3
		System.out.println("�����������߶�=" + avlTree.getRoot().leftHight()); // 2
		System.out.println("�����������߶�=" + avlTree.getRoot().ringhtHight()); // 2
		System.out.println("��ǰ�ĸ����=" + avlTree.getRoot());//8
		
	}

}
class AvlTree{
	private Node root;
	
	
	
	//��ӽڵ�
	public void add(Node node){
		if(root==null){
			root=node;
		}else{
			root.add(node);
		}
	}
	//��ȡ���ڵ�
	public  Node getRoot() {
		return root;
	}
	//�������
	public void infixOrder() {
		if(root==null){
			System.out.println("����");
		}else{
			root.infixOreder();
		}
	}

}

//�����ڵ�
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
	//�����������ĸ߶�
	public int leftHight() {
		if (left == null) {
			return 0;
		}
		return left.TreeHight();
	}

	// �����������ĸ߶�
	public int ringhtHight() {
		if (right == null) {
			return 0;
		}
		return right.TreeHight();
	}
	
	//���ص�ǰ���ĸ߶�
	public int TreeHight(){
		return Math.max(left==null?0:left.TreeHight(), right==null?0:right.TreeHight())+1;
	}
	//����ת
	public void Leftrotate() {
		//����һ���½ڵ� �����ڴ���Ľڵ�
		Node newnode =new Node(val) ;
		//���´����Ľڵ�������� 
	    newnode.left=left;
	    newnode.right=right.left;
	    //�����µĸ��ڵ�
	    val=right.val;
	    //���µĸ��ڵ㶨������
	    left=newnode;
	    right=right.right;	
	}
	//����ת
    public void Rightrotate() {
		// ����һ���½ڵ� �����ڴ���Ľڵ�
		Node newnode = new Node(val);
		// ���´����Ľڵ��������
		newnode.right = right;
		newnode.left = left.right;
		// �����µĸ��ڵ�
		val = left.val;
		// ���µĸ��ڵ㶨������
		left = left.left;
		right = newnode;
	}

	// �ݹ����
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
		//�������߶�>�������߶� 
		if (ringhtHight() - leftHight()>1) {// ����ת
			// �������е��������߶ȴ��������� Ӧ���Ƚ�������ת
			if (right!=null&&right.leftHight() > right.ringhtHight()) {
				right.Rightrotate();
				Leftrotate();
			} else {
				Leftrotate();
			}
                 return;
		}
		//�������߶�<�������߶� 
		if(leftHight()-ringhtHight()>1){//����ת
			// �������е��������߶ȴ��������� Ӧ���Ƚ�������ת
			if (left!=null&&left.ringhtHight() > left.leftHight()) {
				left.Leftrotate();
				Rightrotate();
			} else {
				Rightrotate();
			}
		}	
	}

	// �������
	public void infixOreder() {
		if (this.left != null) {
			this.left.infixOreder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOreder();
		}
	}

	// Ѱ�Ҵ�ɾ���ڵ�
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

	// Ѱ�Ҵ�ɾ���ĸ��ڵ�
	public Node searchParent(int value) {
		// �����ǰ������Ҫɾ���Ľ��ĸ���㣬�ͷ���
		if ((this.left != null && this.left.val == value) || (this.right != null && this.right.val == value)) {
			return this;
		} else {
			// ������ҵ�ֵС�ڵ�ǰ����ֵ, ���ҵ�ǰ�������ӽ�㲻Ϊ��
			if (value < this.val && this.left != null) {
				return this.left.searchParent(value); // ���������ݹ����
			} else if (value >= this.val && this.right != null) {
				return this.right.searchParent(value); // ���������ݹ����
			} else {
				return null; // û���ҵ������
			}
		}

	}

}