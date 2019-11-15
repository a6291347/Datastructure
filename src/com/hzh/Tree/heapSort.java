package com.hzh.Tree;

import java.util.Arrays;

public class heapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr={4,6,8,5,9};
     HeapSort(arr);
     System.out.println(Arrays.toString(arr));
	}

	
	//������
	//������������֮���λ�õ��� ���ö����ֽṹ���򻯴�������
	public static void HeapSort(int[] arr) {
		int temp=0;
		//����������ת���ɶ�
		for(int i=arr.length/2-1;i>=0;i--){
			adjustHeap(arr, i, arr.length);
		}
		//λ�ý��� ʵ����������
		for(int j=arr.length-1;j>0;j--){
			temp=arr[j];
			arr[j]=arr[0];
			arr[0]=temp;
			adjustHeap(arr, 0, j);
		}
		
	}
	
	
	//�����ѣ��󶥶ѣ����򣩺�С���ѣ����� ��
	//i��ʾ��ʼ�ķ�Ҷ�ӽڵ����� len��ʾ��ǰ���鳤��
	public static void adjustHeap(int[] arr,int i,int len) {
		int temp=arr[i];
		for(int k=2*i+1;k<len;k=2*k+1){
			//�ж������ӽڵ��С ����ҽڵ�� ����k�±�
			if(k+1<len&&arr[k]<arr[k+1]){
				k++;
			}
			if(arr[k]>temp){//λ�ý���
				arr[i]=arr[k];
				i=k;//����ѭ���Ա�
			}else{
				break;//˵������Ľڵ�����ö�����
			}
			arr[i]=temp;//����λ��
		}
		
	}
}
