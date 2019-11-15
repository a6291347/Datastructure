package com.hzh.Tree;

import java.util.Arrays;

public class heapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr={4,6,8,5,9};
     HeapSort(arr);
     System.out.println(Arrays.toString(arr));
	}

	
	//堆排序
	//本质上是数组之间的位置调换 采用堆这种结构来简化处理排序
	public static void HeapSort(int[] arr) {
		int temp=0;
		//将无序数组转换成堆
		for(int i=arr.length/2-1;i>=0;i--){
			adjustHeap(arr, i, arr.length);
		}
		//位置交换 实现有序数组
		for(int j=arr.length-1;j>0;j--){
			temp=arr[j];
			arr[j]=arr[0];
			arr[0]=temp;
			adjustHeap(arr, 0, j);
		}
		
	}
	
	
	//创建堆（大顶堆（升序）和小顶堆（降序） ）
	//i表示开始的非叶子节点索引 len表示当前数组长度
	public static void adjustHeap(int[] arr,int i,int len) {
		int temp=arr[i];
		for(int k=2*i+1;k<len;k=2*k+1){
			//判断左右子节点大小 如果右节点大 更新k下标
			if(k+1<len&&arr[k]<arr[k+1]){
				k++;
			}
			if(arr[k]>temp){//位置交换
				arr[i]=arr[k];
				i=k;//继续循环对比
			}else{
				break;//说明下面的节点满足该堆条件
			}
			arr[i]=temp;//交换位置
		}
		
	}
}
