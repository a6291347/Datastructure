package com.hzh.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergerSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr=new int[8000000];
		int[] temp=new int[arr.length];//��ֹ����Խ��
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
	//�ֻ��ϲ��㷨
	public static void mergerSort(int[] arr,int left,int right,int[] temp){
		if(left<right){
			int mid =(left+right)/2;
			//��ֻ�
			mergerSort(arr, left, mid, temp);
			//�ҷֻ�
			mergerSort(arr, mid+1, right, temp);
			//�ϲ�
			merger(arr, left, right, mid, temp);
		}	
	}
	
	
	
	//�ϲ��㷨
	public static void merger(int[] arr, int left, int right, int mid, int[] temp) {
		int l = left;// �������ĳ�ʼ����
		int r = mid + 1;// �Ҳ�����ĳ�ʼ����
		int t = 0;// temp����ĳ�ʼ����
		// 1.���ݽ���
		while (l <= mid && r <= right) {
			// �����С�����ݷ���temp����
			if (arr[l] <= arr[r]) {
				temp[t] = arr[l];
				t += 1;
				l += 1;
			} else {// ���Ҳ�С�����ݷ���temp����
				temp[t] = arr[r];
				t += 1;
				r += 1;
			}
		}
		// 2.��ʣ��һ�������ȫ����䵽temp����
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
		// 3.��temp�����Ԫ���������� ��ʼ����arr
		// �����㷨ʹ�õݹ���� left right �ڵݹ鿪�ٵ���ջ�ռ��н�
		// ���Ϸ����ı� ����temp[]����ռ佫һֱ������
		t = 0;
		int templeft = left;
		while (templeft <= right) {
			arr[templeft] = temp[t];
			t += 1;
			templeft += 1;
		}

	}

}
