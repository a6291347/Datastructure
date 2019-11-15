package com.hzh.Tree;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����
		HeroNode heroNode = new HeroNode(1, "�ν�");
		HeroNode heroNode1 = new HeroNode(2, "����");
		HeroNode heroNode2 = new HeroNode(3, "¬����");
		HeroNode heroNode3 = new HeroNode(4, "�ֳ�");
		HeroNode heroNode4 = new HeroNode(5, "��ʤ");
		heroNode.setLeft(heroNode1);
		heroNode.setRight(heroNode2);
		heroNode2.setRight(heroNode3);
		heroNode2.setLeft(heroNode4);
		Bindary bb=new Bindary();
		bb.setRoot(heroNode);
		System.out.println("ɾ����ǰ");//12354
	    bb.preOrder();
	    bb.del(3);
        System.out.println("ɾ���Ժ�");//1254
        bb.preOrder();
	}

}



//���������� 
class Bindary{
	//��Ҫһ��root�ڵ�
	private HeroNode root;

	public HeroNode getRoot() {
		return root;
	}

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	public void preOrder(){
		if(this.root!=null){
			this.root.preOrder();
		}else{
			System.out.println("������Ϊ�� ���޷�����");
		}
	}
	public void Order(){
		if(this.root!=null){
			this.root.infixOrder();
		}else{
			System.out.println("������Ϊ�� ���޷�����");
		}
	}
	public void postOrder(){
		if(this.root!=null){
			this.root.postOrder();
		}else{
			System.out.println("������Ϊ�� ���޷�����");
		}
		
	}
	
	public HeroNode preOrderSearc(int no) {
		//HeroNode temp = null;
		if (this.root != null) {
			return this.root.preOrderSearch(no);
		} else {
			return null;
		}
		//return temp;
	}

	public HeroNode infixOrderSearc(int no) {
		HeroNode temp = null;
		if (this.root != null) {
			temp = this.root.infixOrderSearch(no);
		} else {
			System.out.println("������Ϊ�� ���޷�����");
		}
		return temp;
	}

	public HeroNode postOrderSearc(int no) {
		HeroNode temp = null;
		if (this.root != null) {
			temp = this.root.postOrderSearch(no);
		} else {
			System.out.println("������Ϊ�� ���޷�����");
		}
		return temp;
	}
	public void del(int no) {
		if(this.root!=null){
			if(this.root.getId()==no){
				this.root=null;
			}else{
				this.root.del(no);
			}
		}else{
			System.out.println("������Ϊ�� ���޷�����");	
		}
	}
	
	
}






//�����ڵ�
class HeroNode{
	private int id; 
	private String name;
	private HeroNode left;
	private HeroNode right;
	public HeroNode(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HeroNode getLeft() {
		return left;
	}
	public void setLeft(HeroNode left) {
		this.left = left;
	}
	public HeroNode getRight() {
		return right;
	}
	public void setRight(HeroNode right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "HeroNode [id=" + id + ", name=" + name + "]";
	}
	
	//ǰ�����  ˳�� ��ǰ��������-����
	public void preOrder(){
		System.out.println(this);
		if(this.left!=null){
			this.left.preOrder();
		}
		if(this.right!=null){
			this.right.preOrder();
		}
	}
	
	//�������  ˳�� ���󡪡�����-����
	public void infixOrder(){
		if(this.left!=null){
			this.left.preOrder();
		}
		System.out.println(this);
		if(this.right!=null){
			this.right.preOrder();
		}
	}
	
	//�������  ˳�� ���󡪡�����-����
		public void postOrder(){
			if(this.left!=null){
				this.left.preOrder();
			}
			if(this.right!=null){
				this.right.preOrder();
			}
			System.out.println(this);
		}
	//ǰ�����
		public HeroNode preOrderSearch(int no){
			if(this.id==no){
				return this;
			}
			HeroNode temp=null;
			if(this.left!=null){//�������
				temp=this.left.preOrderSearch(no);
			}
			if(temp!=null){
				return temp;
			}
			if(this.right!=null){
				temp=this.right.preOrderSearch(no);
			}
			return temp;
		}

	// �������
	public HeroNode infixOrderSearch(int no) {
		HeroNode temp = null;
		if (this.left != null) {// �������
			temp = this.left.preOrderSearch(no);
		}
		if (temp != null) {
			return temp;
		}
		if (this.id == no) {
			return this;
		}
		if (this.right != null) {
			temp = this.right.preOrderSearch(no);
		}
		return temp;
	}

	// �������
	public HeroNode postOrderSearch(int no) {
		HeroNode temp = null;
		if (this.left != null) {// �������
			temp = this.left.preOrderSearch(no);
		}
		if (temp != null) {
			return temp;
		}
		if (this.right != null) {
			temp = this.right.preOrderSearch(no);
		}
		if (this.id == no) {
			return this;
		}

		return temp;
	}
	
	public void del(int no) {
		if (this.left != null && this.left.getId() == no) {
			HeroNode cur=null;
			if(this.left.left!=null&&this.left.right!=null){
				cur=this.left.right;
				this.left=this.left.left;
				this.left.right=cur;
				return;
			}else if(this.left.left!=null){
				this.left=this.left.left;
				return;
			}else if(this.left.right!=null){
				this.left=this.left.right;
				return;
			}else{
				this.left = null;
				return;
			}
			
		}
		if (this.right != null && this.right.getId() == no) {
			HeroNode cur=null;
			if(this.right.left!=null&&this.right.right!=null){
				cur=this.right.right;
				this.right=this.right.left;
				this.right.right=cur;
				return;
			}else if(this.right.left!=null){
				this.right=this.right.left;
				return;
			}else if(this.right.right!=null){
				this.right=this.right.right;
				return;
			}else{
				this.right = null;
				return;
			}
			
		}
		// ����ݹ�
		if (this.left != null) {
			this.left.del(no);
		}
		// ���ҵݹ�
		if (this.right != null) {
			this.right.del(no);
		}

	}

}
