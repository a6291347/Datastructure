package com.hzh.search;

public class insertValueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[100];
		for(int i=0;i<100;i++){
			arr[i]=i+1;
		}
		int index = insertSearch(arr, 0, arr.length-1, 22);
		System.out.println("index="+index);

	}
	
	public static int  insertSearch(int[] arr,int left,int right,int findval) {
		
		if (left > right || findval < arr[left] || findval > arr[right - 1]) {
			return -1;
		}
		// 优化定位 插值查找的灵魂
		int mid = left + (right - left) * (findval - arr[left]) / (arr[right] - arr[left]);
		int midval = arr[mid];
		if (findval > midval) {// 向右递归
			return insertSearch(arr, left, mid - 1, findval);
		} else if (findval < midval) {
			return insertSearch(arr, mid + 1, right, findval);
		} else {
			return mid;
		}
	}

}
