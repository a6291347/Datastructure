package com.hzh.sort;

import java.util.Arrays;

public class BinarySortnonrecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 3, 8, 10, 11, 67, 100, 99, 13 };
	    Arrays.sort(arr);
		int index = BinartSort(arr, 13);
		System.out.println(index);
	}
	
	//返回查找数的索引 
	//不存在返回-1
	public static int BinartSort(int arr[],int val) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) { //说明继续查找
			int mid = (left + right) / 2;
			if(arr[mid] == val) {
				return mid;
			} else if ( arr[mid] > val) {
				right = mid - 1;//需要向左边查找
			} else {
				left = mid + 1; //需要向右边查找
			}
		}
		return -1;
	}


}
