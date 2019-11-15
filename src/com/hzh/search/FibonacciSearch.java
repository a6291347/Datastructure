package com.hzh.search;

import java.util.Arrays;

public class FibonacciSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,8,10,89,1000,1234};
		int index = fibonacci(arr,1 );
		System.out.println(index);
	}
	
	//���쳲��������� �ǵݹ�
	public static int[] fi() {
		int[] fi=new int[20];
		fi[0]=1;
		fi[1]=1;
		for(int i=2;i<fi.length;i++){
			fi[i]=fi[i-1]+fi[i-2];
		}
		return fi;
	}
	
	//쳲���������  ǰ������ ��������
	//mid=low+F(k-1)-1
	public static int fibonacci(int[] arr, int findval) {
		int low = 0;
		int right = arr.length - 1;
		int k = 0;// 쳲������ָ�ֵ�±�
		int mid = 0;
		int[] fi = fi();
		// ȡ���±�
		while (right > fi[k] - 1) {
			k++;
		}
		// ����ܹ����зָ��쳲���������
		int[] temp = Arrays.copyOf(arr, fi[k]);
		// fi[k]���ܴ���arr�ĳ��� �������ĳ��ȸ�ֵ�� arr[right]
		for (int i = right + 1; i < temp.length; i++) {
			temp[i] = arr[right];
		}

		// ʹ��whileѭ�� ���ҵ�findval
		while (right >= low) {
			mid = low + fi[k - 1] - 1;
			if (findval < temp[mid]) {// ��ǰ���� ��
				right = mid - 1;
				k--;
			} else if (findval >temp[mid]) {
				low = mid + 1;
				k -= 2;
			} else {// �ҵ�
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
