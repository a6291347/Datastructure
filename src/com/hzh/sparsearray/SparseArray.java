package com.hzh.sparsearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SparseArray {

	public static void main(String[] args) throws IOException {
		
		int[][] array1 = new int[11][11];
		// 1��ʾ���� 2��ʾ���� 0Ϊ����
		array1[1][3] = 1;
		array1[3][4] = 2;
		array1[3][6] = 1;

		// ���ԭʼ��ά����
		for (int[] data : array1) {
			for (int row : data) {
				System.out.printf("%d\t", row);
			}
			System.out.println();
		}

		// ����ϡ������
		// 1.������Ч����
		int sum = 0;
		for (int[] data : array1) {
			for (int row : data) {
				if (row != 0) {
					sum++;
				}
			}
		}
		System.out.println("��Ч������" + sum);

		// 2.����ϡ������ԭ��
		int[][] sparsearray = new int[sum + 1][3];
		// 3.�����鸳ֵ
		sparsearray[0][0] = 11;
		sparsearray[0][1] = 11;
		sparsearray[0][2] = sum;
		int count = 0;
		for (int i = 0; i < 11; i++) {
			for (int k = 0; k < 11; k++) {
				if(array1[i][k]!=0){
					count++;
					sparsearray[count][0] = i;
					sparsearray[count][1] = k;
					sparsearray[count][2] = array1[i][k];
				}
				
			}
		}
		// ���ϡ������
		for (int i = 0; i < sparsearray.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparsearray[i][0], sparsearray[i][1], sparsearray[i][2]);
			System.out.println();
		}
		//��ϡ������д�����
		Writer(sparsearray,"data.txt");
		//�������ļ���ȡ��ϡ������
		int[][] xinsparsearray=read("data.txt");
        //�ָ�ԭʼ��ά����
	   int[][] array2=new int[xinsparsearray[0][0]][xinsparsearray[0][1]];
	   for(int i=1;i<xinsparsearray.length;i++){
		   array2[xinsparsearray[i][0]][xinsparsearray[i][1]]=xinsparsearray[i][2];
	   }
	   //����
	   System.out.println("--------");
	   for (int[] data : array2) {
			for (int row : data) {
				System.out.printf("%d\t", row);
			}
			System.out.println();
		}
	}
	

	
	public static int[][] read(String path) throws NumberFormatException, IOException {
		// �������ļ���ȡ�����
		List<int[]> list = new ArrayList<>();
		FileReader fr = new FileReader(new File(path));
		BufferedReader br = new BufferedReader(fr);
		String str = null;
		while ((str = br.readLine()) != null) {
			String[] line = str.split(" ");
			int[] item = new int[line.length];
			for (int i = 0; i < line.length; i++) {
				item[i] = Integer.valueOf(line[i]);
			}
			list.add(item);
		}
		int[][] newsparsearray = new int[list.size()][3];
		for (int k = 0; k < list.size(); k++) {
			int[] item = list.get(k);
			newsparsearray[k][0] = item[0];
			newsparsearray[k][1] = item[1];
			newsparsearray[k][2] = item[2];
		}
		System.out.println("��ȡ�ɹ�");
		return newsparsearray;

	}

	public static void Writer(int[][] cc, String path) {

		File file = new File(path);
		try {
			FileWriter fw = new FileWriter(file);
			for (int i = 0; i < cc.length; i++) {
				for (int j = 0; j < 3; j++) {
					fw.write(cc[i][j] + " ");
				}
				fw.write("\r\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("д��ɹ�");
	}

}
