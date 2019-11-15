package com.hzh.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class selectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array =new int[80000];
		   for(int i=0;i<80000;i++){
			   array[i]=(int)(Math.random()*80000);
		   }
	          Date date1=new Date();
	          SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	          String format = s1.format(date1);
	          System.out.println(format);
	         select(array);
	          Date date2=new Date();
	          String format1 = s1.format(date2);
	          System.out.println(format1);
	}
	
	
	public static void select(int[] array) {
		for(int i=0;i<array.length-1;i++){
			int minindex=i;
			int min=array[i];
			for(int j=i+1;j<array.length;j++){
				if(min>=array[j]){
					min=array[j];
					minindex=j;
				}
			}
			if(minindex!=i){
				array[minindex]=array[i];
				array[i]=min;
			}
			
		}
	}

}
