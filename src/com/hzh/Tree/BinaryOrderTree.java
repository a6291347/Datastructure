package com.hzh.Tree;

public class BinaryOrderTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,2,3,4,5,6,7};
		BinaryOrder bb=new BinaryOrder(arr);
		bb.infixder(0);//4251637
		System.out.println();
		bb.psotder(0);//4526731
	}
	
	
}
class BinaryOrder{
	private int[] arr;
	public BinaryOrder(int[] arr){
		this.arr=arr;
	}
	
	// 按照前序遍历
	public void order(int index) {
		if (index < 0 || index > arr.length) {
			System.out.println("索引越界,请检查后输入");
		}
		System.out.print(arr[index]);
		// 左节点索引 index*2+1 右节点 index*2+2
		if ((index * 2 + 1) < arr.length) {
			order(index * 2 + 1);
		}
		// 右节点索引
		if ((index * 2 + 2) < arr.length) {
			order(index * 2 + 2);
		}
	}
	// 按照中序遍历
	public void infixder(int index) {
		if (index < 0 || index > arr.length) {
			System.out.println("索引越界,请检查后输入");
		}
		// 左节点索引 index*2+1 右节点 index*2+2
		if ((index * 2 + 1) < arr.length) {
			infixder(index * 2 + 1);
		}
		System.out.print(arr[index]);
		// 右节点索引
		if ((index * 2 + 2) < arr.length) {
			infixder(index * 2 + 2);
		}
	}

	// 按照后序遍历
	public void psotder(int index) {
		if (index < 0 || index > arr.length) {
			System.out.println("索引越界,请检查后输入");
		}
		// 左节点索引 index*2+1 右节点 index*2+2
		if ((index * 2 + 1) < arr.length) {
			psotder(index * 2 + 1);
		}
		// 右节点索引
		if ((index * 2 + 2) < arr.length) {
			psotder(index * 2 + 2);
		}
		System.out.print(arr[index]);
	}

}
