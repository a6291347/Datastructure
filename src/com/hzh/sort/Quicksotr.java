package com.hzh.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Quicksotr {
	public static void main(String[] args) {
		int[] arr = new int[80000000];
		for (int i = 0; i < 80000000; i++) {
			arr[i] = (int) (Math.random() * 800000);
		}
		Date date1 = new Date();
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = s1.format(date1);
		System.out.println(format);
		quickSort(arr, 0, arr.length - 1);
		Date date2 = new Date();
		String format1 = s1.format(date2);
		System.out.println(format1);

	}
	
	public static void quickSort(int[] arr, int left, int right) {
		int l = left;
		int r = right;
		int mid = (l + r) / 2;
		int temp = 0;
		while (r > l) {
			// 寻找左边比arr[mid]大的数
			while (arr[l] < arr[mid]) {
				l += 1;
			}
			// 寻找右边比arr[mid]小的数
			while (arr[r] > arr[mid]) {
				r -= 1;
			}
			// 跳出循环则表示找到符合条件的数
			// 交换位置
			temp = arr[r];
			arr[r] = arr[l];
			arr[l] = temp;

			// 若l>=r则说明左右侧都符合本次排序条件 跳出循环
			if (l >= r) {
				break;
			}
			// 防止出现和arr[mid]相同的数
			// 右侧相同 左侧后移
			if (arr[r] == arr[mid]) {
				l += 1;
			}
			// 左侧相同 右侧前移
			if (arr[l] == arr[mid]) {
				r -= 1;
			}

		}
		// 防止栈溢出（死循环）
		if (l == r) {
			l += 1;
			r -= 1;
		}
		// 左递归
		if (r > left) {
			quickSort(arr, left, r);
		}
		// 右递归
		if (right > l) {
			quickSort(arr, l, right);

		}
	}

}
