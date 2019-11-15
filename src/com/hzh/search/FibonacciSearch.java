package com.hzh.search;

import java.util.Arrays;

public class FibonacciSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,8,10,89,1000,1234};
		int index = fibonacci(arr,1 );
		System.out.println(index);
	}
	
	//获得斐波那契数列 非递归
	public static int[] fi() {
		int[] fi=new int[20];
		fi[0]=1;
		fi[1]=1;
		for(int i=2;i<fi.length;i++){
			fi[i]=fi[i-1]+fi[i-2];
		}
		return fi;
	}
	
	//斐波那契查找  前提条件 有序数组
	//mid=low+F(k-1)-1
	public static int fibonacci(int[] arr, int findval) {
		int low = 0;
		int right = arr.length - 1;
		int k = 0;// 斐波那契分割值下标
		int mid = 0;
		int[] fi = fi();
		// 取得下标
		while (right > fi[k] - 1) {
			k++;
		}
		// 获得能够进行分割的斐波那契数列
		int[] temp = Arrays.copyOf(arr, fi[k]);
		// fi[k]可能大于arr的长度 将超出的长度赋值成 arr[right]
		for (int i = right + 1; i < temp.length; i++) {
			temp[i] = arr[right];
		}

		// 使用while循环 来找到findval
		while (right >= low) {
			mid = low + fi[k - 1] - 1;
			if (findval < temp[mid]) {// 向前查找 左
				right = mid - 1;
				k--;
			} else if (findval >temp[mid]) {
				low = mid + 1;
				k -= 2;
			} else {// 找到
				if (mid <= right) {
					return mid;
				} else {
					return right;
				}
			}

		}
		return -1;

	}
}
