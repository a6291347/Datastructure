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
			// Ѱ����߱�arr[mid]�����
			while (arr[l] < arr[mid]) {
				l += 1;
			}
			// Ѱ���ұ߱�arr[mid]С����
			while (arr[r] > arr[mid]) {
				r -= 1;
			}
			// ����ѭ�����ʾ�ҵ�������������
			// ����λ��
			temp = arr[r];
			arr[r] = arr[l];
			arr[l] = temp;

			// ��l>=r��˵�����Ҳ඼���ϱ����������� ����ѭ��
			if (l >= r) {
				break;
			}
			// ��ֹ���ֺ�arr[mid]��ͬ����
			// �Ҳ���ͬ ������
			if (arr[r] == arr[mid]) {
				l += 1;
			}
			// �����ͬ �Ҳ�ǰ��
			if (arr[l] == arr[mid]) {
				r -= 1;
			}

		}
		// ��ֹջ�������ѭ����
		if (l == r) {
			l += 1;
			r -= 1;
		}
		// ��ݹ�
		if (r > left) {
			quickSort(arr, left, r);
		}
		// �ҵݹ�
		if (right > l) {
			quickSort(arr, l, right);

		}
	}

}
