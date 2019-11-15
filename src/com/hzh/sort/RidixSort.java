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
		//当初始数组空间太大时 会报错=（堆空间溢出） 同时需要注意负数的问题 
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
		// 求出数组中的最大数的位数
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		String len = max + "";
		int l = len.length();
		// 基数排序
		// 开辟二维数组（桶）
		int[][] bucket = new int[10][arr.length];
		// 开辟记录每个桶中元素的个数的数组 以下标对应每个桶的下标 以值来对应每个
		// 桶的元素个数
		int[] number = new int[10];
		// 需要排序l轮
		for (int i = 0, n = 1; i < l; i++, n *= 10) {
			// 取出数组中所有的元素进行 比较
			for (int k = 0; k < arr.length; k++) {
				// 对于不满足条件的数 则直接补0
				int value = arr[k] / n % 10;
				bucket[value][number[value]] = arr[k];
				number[value]++;
			}
			// 将每个桶中的数据从小到大取出
			// 需要一个下标给arr数组赋值
			int index = 0;
			for (int k = 0; k < number.length; k++) {
				// 判断为k下标的桶子中是否存在元素
				if (number[k] != 0) {
					// 遍历 赋值
					for (int j = 0; j < number[k]; j++) {
						arr[index++] = bucket[k][j];
					}
				}
				//赋值后将为k下标的桶子元素个数清0 为下轮准备
				number[k] = 0;
			}
		
		}

	}
}
