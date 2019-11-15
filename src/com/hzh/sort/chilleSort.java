package com.hzh.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class chilleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array =new int[80000000];
		   for(int i=0;i<80000000;i++){
			   array[i]=(int)(Math.random()*80000);
		   }
	          Date date1=new Date();
	          SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	          String format = s1.format(date1);
	          System.out.println(format);
	          //chille(array);
	          Shell(array);
	         // System.out.println(Arrays.toString(array));
	          Date date2=new Date();
	          String format1 = s1.format(date2);
	          System.out.println(format1);

	}
	//交换法
	public static void chille(int[] arr) {
		int temp=0;
		//分化次数
		for(int gap=arr.length/2;gap>0;gap/=2){
			//分组排序
			for(int i=gap;i<arr.length;i++){
				//按照步长插入排序 步长=分组数=gap
				for(int k=i-gap;k>=0;k-=gap){
					if(arr[k]>arr[k+gap]){
						temp=arr[k];
						arr[k]=arr[k+gap];
						arr[k+gap]=temp;
					}
				}
			}
		}
	}
	//移步法 缩小增量排序
	public static void Shell(int[] arr) {
		for(int gap=arr.length;gap>0;gap/=2){
			for(int i=gap;i<arr.length;i++){
				int val=arr[i];
				int minindex=i;
				if(arr[minindex]<arr[minindex-gap]){
					while(minindex-gap>=0&&val<arr[minindex-gap]){
						//移步
						arr[minindex]=arr[minindex-gap];
						minindex-=gap;
					}
					arr[minindex]=val;
				}
			}
		}
		
	}

}
