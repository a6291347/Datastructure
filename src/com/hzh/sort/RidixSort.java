package com.hzh.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RidixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  /*  int[] arr={53,3,542,748,14,214};
	    radixSort(arr);
	    System.out.println(Arrays.toString(arr));*/
		//����ʼ����ռ�̫��ʱ �ᱨ��=���ѿռ������ ͬʱ��Ҫע�⸺�������� 
		int [] arr=new int[8000000];
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*80000);
		}
		  Date date1=new Date();
          SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String format = s1.format(date1);
          System.out.println(format);
          radixSort(arr);
         //System.out.println(Arrays.toString(arr));
          Date date2=new Date();
          String format1 = s1.format(date2);
          System.out.println(format1);
	   
	}


	public static void radixSort(int[] arr) {
		// ��������е��������λ��
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		String len = max + "";
		int l = len.length();
		// ��������
		// ���ٶ�ά���飨Ͱ��
		int[][] bucket = new int[10][arr.length];
		// ���ټ�¼ÿ��Ͱ��Ԫ�صĸ��������� ���±��Ӧÿ��Ͱ���±� ��ֵ����Ӧÿ��
		// Ͱ��Ԫ�ظ���
		int[] number = new int[10];
		// ��Ҫ����l��
		for (int i = 0, n = 1; i < l; i++, n *= 10) {
			// ȡ�����������е�Ԫ�ؽ��� �Ƚ�
			for (int k = 0; k < arr.length; k++) {
				// ���ڲ������������� ��ֱ�Ӳ�0
				int value = arr[k] / n % 10;
				bucket[value][number[value]] = arr[k];
				number[value]++;
			}
			// ��ÿ��Ͱ�е����ݴ�С����ȡ��
			// ��Ҫһ���±��arr���鸳ֵ
			int index = 0;
			for (int k = 0; k < number.length; k++) {
				// �ж�Ϊk�±��Ͱ�����Ƿ����Ԫ��
				if (number[k] != 0) {
					// ���� ��ֵ
					for (int j = 0; j < number[k]; j++) {
						arr[index++] = bucket[k][j];
					}
				}
				//��ֵ��Ϊk�±��Ͱ��Ԫ�ظ�����0 Ϊ����׼��
				number[k] = 0;
			}
		
		}

	}
}
