package com.hzh.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class bubblingSort {

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
          bubb(array);
          Date date2=new Date();
          String format1 = s1.format(date2);
          System.out.println(format1);
	}
	
	
	public static void bubb(int[] arrat) {
		int temp = 0;
		boolean flag = false;
		for (int i = 0; i < arrat.length - 1; i++) {
			for (int j = 0; j < arrat.length - 1 - i; j++) {
				if (arrat[j] > arrat[j + 1]) {
					flag = true;
					temp = arrat[j];
					arrat[j] = arrat[j + 1];
					arrat[j + 1] = temp;
				}
			}
			// System.out.println("µÚ"+i+"ÌÉ½»»»Î»ÖÃ");
			if (!flag) {
				break;
			} else {
				flag = false;
			}
		}
	}

}
