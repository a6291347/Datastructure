package com.hzh.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={121,4,23,23,23,54,45,65,-2};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		List<Integer> binarysearch2 = binarysearch2(arr, 0, arr.length-1, 23);
		 System.out.println(binarysearch2);

	}
	
	
	//二分查找 前提是有序数组
	//单个查找
	public static int binarysearch(int[] arr,int left,int right,int findval) {
		
		int mid=(left+right)/2;
		int midval=arr[mid];
		
		//没找到就返回-1
		if(left>right){
			return -1;
		}
		
		//找到就返回下标
		if(findval>midval){//向右递归
			return binarysearch(arr, mid + 1, right, findval);
		}else if(findval<midval){//向左递归
			return binarysearch(arr, left, mid - 1, findval);
		}else{
			return mid;
		}
		
	}
	
	//多个查找
    public static List<Integer> binarysearch2(int[] arr,int left,int right,int findval) {
		
		int mid=(left+right)/2;
		int midval=arr[mid];
		
		//没找到就返回空的list
		if(left>right){
			return new ArrayList<>();
		}
		
		//找到就返回下标
		if(findval>midval){//向右递归
			return binarysearch2(arr, mid + 1, right, findval);
		}else if(findval<midval){//向左递归
			return binarysearch2(arr, left, mid - 1, findval);
		}else{
			List<Integer> list=new ArrayList<>();
			//向左侧查找相同元素
			Integer temp=mid-1;
			while(true){
				if(temp<0||arr[temp]!=findval){
				break;
				}
				list.add(temp);
				temp-=1;
			}
			list.add(mid);
			//向右查找相同元素
			temp=mid+1;
			while(true){
				if(temp>right||arr[temp]!=findval){
				break;
				}
				list.add(temp);
				temp+=1;
			}
			return list;
		
	}

 }
}
