package com.hzh.queue;

/**
 * @author ������
 *
 */
/**
 * @author ������
 *
 */
/**
 * @author ������
 *
 */
public class Mikong {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //�����ͼ
		 int[][] array=new int[8][7];
		 //��ʼ����ͼ
		 //1��ʾǽ�� 2��ʾ�����ߵķ��� 3��ʾ�÷����޷��ҵ����� 0��ʾû���߹��ķ���
		 for(int i=0;i<7;i++){
			 array[0][i]=1;
			 array[7][i]=1;
		 } 
		 for(int i=0;i<8;i++){
			 array[i][0]=1;
			 array[i][6]=1;
		 }
		 array[3][1]=1;
		 array[3][2]=1;
		 System.out.println("��ӡ��ʼ����ͼ");
		 for(int i=0;i<8;i++){
			 for(int k=0;k<7;k++){
				 System.out.print(array[i][k]+" ");
			 }
			 System.out.println();
		 }
		 swap(array, 1, 1);
		 System.out.println("��ӡ�Թ�·��");
		 for(int i=0;i<8;i++){
			 for(int k=0;k<7;k++){
				 System.out.print(array[i][k]+" ");
			 }
			 System.out.println();
		 }
	}
	
	
	
	
	//��������Թ����ݹ飩
	//���� i kΪ��ʼ���� (1,1)
	//��array[i][k]==array[6][5]��ͨ���Թ�
	//�������߲��� �¡����ҡ������ϡ�������
	public static boolean swap(int[][] array,int i,int k) {
		//�������
		if(array[6][5]==2){
			return true;
		}else{
			if(array[i][k]==0){//��ǰ��û���߹��÷���
				array[i][k]=2;
				if(swap(array,i+1,k)){//������
					return true;
				}else if(swap(array,i,k+1)){//������
					return true;
				}else if(swap(array,i-1,k+1)){//������
					return true;
				}else if(swap(array,i,k-1)){//������
					return true;
				}else{//�߲�ͨ
					array[i][k]=3;
				}
				return false;
			}else{//����Ϊ0��ǰ�������Ϊ1��2��3
				return false;
			}
		}
		
	}

}
