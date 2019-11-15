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
			System.out.println("是空树,无法遍历");
		}
	}
	
	public static Node createHuffmanTree(int[] arr) {
		//将数组添加到集合中
		List<Node> nodes= new ArrayList<>();
		for(int temp:arr){
			nodes.add(new Node(temp));
		}
	
		
		//处理节点
		while(nodes.size()>1){
			//给集合排序
			Collections.sort(nodes);
			//取出权值最小的两颗二叉树
			Node leftNode=nodes.get(0);
			Node rightNode=nodes.get(1);
			//创建新的二叉树
			Node newNode=new Node(leftNode.val+rightNode.val);
			newNode.left=leftNode;
			newNode.right=rightNode;
			//移除已经处理的二叉树
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//将节点加入list
			nodes.add(newNode);
			
		}
		
		return nodes.get(0);
	}
	
	
	

}



//创建节点 
//实现排序
class Node implements Comparable<Node>{
	int val;//权值
	Node left;//左节点
	Node right;//右节点
	
	public Node(int value) {
		this.val=value;
	}

	
	
	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}


     //从小到大
	@Override
	public int compareTo(Node o1) {
		// TODO Auto-generated method stub
		return this.val-o1.val;
	}
	
	//前序遍历
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
