package com.hzh.queue;

/**
 * @author 局外人
 *
 */
/**
 * @author 局外人
 *
 */
/**
 * @author 局外人
 *
 */
public class Mikong {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //定义地图
		 int[][] array=new int[8][7];
		 //初始化地图
		 //1表示墙壁 2表示可以走的房间 3表示该房间无法找到出口 0表示没有走过的房间
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
		 System.out.println("打印初始化地图");
		 for(int i=0;i<8;i++){
			 for(int k=0;k<7;k++){
				 System.out.print(array[i][k]+" ");
			 }
			 System.out.println();
		 }
		 swap(array, 1, 1);
		 System.out.println("打印迷宫路线");
		 for(int i=0;i<8;i++){
			 for(int k=0;k<7;k++){
				 System.out.print(array[i][k]+" ");
			 }
			 System.out.println();
		 }
	}
	
	
	
	
	//回溯求解迷宫（递归）
	//定义 i k为初始坐标 (1,1)
	//当array[i][k]==array[6][5]则通过迷宫
	//定义行走策略 下—》右——》上——》左
	public static boolean swap(int[][] array,int i,int k) {
		//定义出口
		if(array[6][5]==2){
			return true;
		}else{
			if(array[i][k]==0){//当前还没有走过该房间
				array[i][k]=2;
				if(swap(array,i+1,k)){//向下走
					return true;
				}else if(swap(array,i,k+1)){//向右走
					return true;
				}else if(swap(array,i-1,k+1)){//向上走
					return true;
				}else if(swap(array,i,k-1)){//向左走
					return true;
				}else{//走不通
					array[i][k]=3;
				}
				return false;
			}else{//若不为0则当前房间可能为1，2，3
				return false;
			}
		}
		
	}

}
