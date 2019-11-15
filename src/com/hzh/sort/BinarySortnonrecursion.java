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
	
	//���ز����������� 
	//�����ڷ���-1
	public static int BinartSort(int arr[],int val) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) { //˵����������
			int mid = (left + right) / 2;
			if(arr[mid] == val) {
				return mid;
			} else if ( arr[mid] > val) {
				right = mid - 1;//��Ҫ����߲���
			} else {
				left = mid + 1; //��Ҫ���ұ߲���
			}
		}
		return -1;
	}


}
