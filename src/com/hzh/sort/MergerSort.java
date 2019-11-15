package com.hzh.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergerSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr=new int[8000000];
		int[] temp=new int[arr.length];//防止数组越界
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*80000);
		}
		   Date date1=new Date();
	          SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	          String format = s1.format(date1);
	          System.out.println(format);
	          mergerSort(arr, 0, arr.length-1, temp);
	         //System.out.println(Arrays.toString(arr));
	          Date date2=new Date();
	          String format1 = s1.format(date2);
	          System.out.println(format1);


	}
	//分化合并算法
	public static void mergerSort(int[] arr,int left,int right,int[] temp){
		if(left<right){
			int mid =(left+right)/2;
			//左分化
			mergerSort(arr, left, mid, temp);
			//右分化
			mergerSort(arr, mid+1, right, temp);
			//合并
			merger(arr, left, right, mid, temp);
		}	
	}
	
	
	
	//合并算法
	public static void merger(int[] arr, int left, int right, int mid, int[] temp) {
		int l = left;// 左侧数组的初始索引
		int r = mid + 1;// 右侧数组的初始索引
		int t = 0;// temp数组的初始索引
		// 1.数据交换
		while (l <= mid && r <= right) {
			// 将左侧小的数据放入temp数组
			if (arr[l] <= arr[r]) {
				temp[t] = arr[l];
				t += 1;
				l += 1;
			} else {// 将右侧小的数据放入temp数组
				temp[t] = arr[r];
				t += 1;
				r += 1;
			}
		}
		// 2.将剩余一组的数据全部填充到temp数组
		while (l <= mid) {
			temp[t] = arr[l];
			t += 1;
			l += 1;
		}
		while (r<= right) {
			temp[t] = arr[r];
			t += 1;
			r += 1;
		}
		// 3.将temp数组的元素依次填入 初始数组arr
		// 考虑算法使用递归机制 left right 在递归开辟的新栈空间中将
		// 不断发生改变 但是temp[]数组空间将一直被共用
		t = 0;
		int templeft = left;
		while (templeft <= right) {
			arr[templeft] = temp[t];
			t += 1;
			templeft += 1;
		}

	}

}
