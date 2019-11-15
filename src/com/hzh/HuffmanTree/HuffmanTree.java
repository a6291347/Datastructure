package com.hzh.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={13,7,8,3,29,6,1};
		Node createHuffmanTree = createHuffmanTree(arr);
		preorder(createHuffmanTree);

	}
	
	public static void preorder(Node root) {
		if(root!=null){
			root.preorder();
		}else{
			System.out.println("�ǿ���,�޷�����");
		}
	}
	
	public static Node createHuffmanTree(int[] arr) {
		//��������ӵ�������
		List<Node> nodes= new ArrayList<>();
		for(int temp:arr){
			nodes.add(new Node(temp));
		}
	
		
		//����ڵ�
		while(nodes.size()>1){
			//����������
			Collections.sort(nodes);
			//ȡ��Ȩֵ��С�����Ŷ�����
			Node leftNode=nodes.get(0);
			Node rightNode=nodes.get(1);
			//�����µĶ�����
			Node newNode=new Node(leftNode.val+rightNode.val);
			newNode.left=leftNode;
			newNode.right=rightNode;
			//�Ƴ��Ѿ�����Ķ�����
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//���ڵ����list
			nodes.add(newNode);
			
		}
		
		return nodes.get(0);
	}
	
	
	

}



//�����ڵ� 
//ʵ������
class Node implements Comparable<Node>{
	int val;//Ȩֵ
	Node left;//��ڵ�
	Node right;//�ҽڵ�
	
	public Node(int value) {
		this.val=value;
	}

	
	
	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}


     //��С����
	@Override
	public int compareTo(Node o1) {
		// TODO Auto-generated method stub
		return this.val-o1.val;
	}
	
	//ǰ�����
	public void preorder(){
		System.out.println(this);
		if(this.left!=null){
			this.left.preorder();
		}
		if(this.right!=null){
			this.right.preorder();
		}
		
	}
	
	
}
