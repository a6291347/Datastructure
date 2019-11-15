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
	
	
	//���ֲ��� ǰ������������
	//��������
	public static int binarysearch(int[] arr,int left,int right,int findval) {
		
		int mid=(left+right)/2;
		int midval=arr[mid];
		
		//û�ҵ��ͷ���-1
		if(left>right){
			return -1;
		}
		
		//�ҵ��ͷ����±�
		if(findval>midval){//���ҵݹ�
			return binarysearch(arr, mid + 1, right, findval);
		}else if(findval<midval){//����ݹ�
			return binarysearch(arr, left, mid - 1, findval);
		}else{
			return mid;
		}
		
	}
	
	//�������
    public static List<Integer> binarysearch2(int[] arr,int left,int right,int findval) {
		
		int mid=(left+right)/2;
		int midval=arr[mid];
		
		//û�ҵ��ͷ��ؿյ�list
		if(left>right){
			return new ArrayList<>();
		}
		
		//�ҵ��ͷ����±�
		if(findval>midval){//���ҵݹ�
			return binarysearch2(arr, mid + 1, right, findval);
		}else if(findval<midval){//����ݹ�
			return binarysearch2(arr, left, mid - 1, findval);
		}else{
			List<Integer> list=new ArrayList<>();
			//����������ͬԪ��
			Integer temp=mid-1;
			while(true){
				if(temp<0||arr[temp]!=findval){
				break;
				}
				list.add(temp);
				temp-=1;
			}
			list.add(mid);
			//���Ҳ�����ͬԪ��
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
