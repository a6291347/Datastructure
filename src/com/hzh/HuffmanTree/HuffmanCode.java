package com.hzh.HuffmanTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		String content = "i like like like java do you like a java";
		byte[] contentBytes = content.getBytes();//40
		byte[] huffmanZip = huffmanZip(contentBytes);
		
		//解码 
		byte[] decode = decode(huffmanCodes, huffmanZip);
		System.out.println(new String(decode));*/
	/*	String zipFile = "C://JavaTestDome/src.bmp";
		String dstFile = "C://JavaTestDome/src2.zip";
		zipFile(zipFile, dstFile);
		System.out.println("压缩成功");*/
		String zipFile = "C://JavaTestDome/src2.zip";
		String dstFile = "C://JavaTestDome/src3.bmp";
		unZipFile(zipFile, dstFile);
		System.out.println("解压成功");
	}
	//编写一个方法，完成对压缩文件的解压
public static void unZipFile(String zipFile, String dstFile) {
		
		//定义文件输入流
		InputStream is = null;
		//定义一个对象输入流
		ObjectInputStream ois = null;
		//定义文件的输出流
		OutputStream os = null;
		try {
			//创建文件输入流
			is = new FileInputStream(zipFile);
			//创建一个和  is关联的对象输入流
			ois = new ObjectInputStream(is);
			//读取byte数组  huffmanBytes
			byte[] huffmanBytes = (byte[])ois.readObject();
			//读取赫夫曼编码表
			Map<Byte,String> huffmanCodes = (Map<Byte,String>)ois.readObject();
			
			//解码
			byte[] bytes = decode(huffmanCodes, huffmanBytes);
			//将bytes 数组写入到目标文件
			os = new FileOutputStream(dstFile);
			//写数据到 dstFile 文件
			os.write(bytes);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			
			try {
				os.close();
				ois.close();
				is.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
			
		}
	}
	
	
	//编写方法，将一个文件进行压缩
public static void zipFile(String srcFile, String dstFile) {
		//创建输出流
		OutputStream os = null;
		ObjectOutputStream oos = null;
		//创建文件的输入流
		FileInputStream is = null;
		try {
			//创建文件的输入流
			is = new FileInputStream(srcFile);
			//创建一个和源文件大小一样的byte[]
			byte[] b = new byte[is.available()];
			//读取文件
			is.read(b);
			//直接对源文件压缩
			byte[] huffmanBytes = huffmanZip(b);
			//创建文件的输出流, 存放压缩文件
			os = new FileOutputStream(dstFile);
			//创建一个和文件输出流关联的ObjectOutputStream
			oos = new ObjectOutputStream(os);
			//把 赫夫曼编码后的字节数组写入压缩文件
			oos.writeObject(huffmanBytes); 
			//这里我们以对象流的方式写入 赫夫曼编码，是为了以后我们恢复源文件时使用
			//注意一定要把赫夫曼编码 写入压缩文件
			oos.writeObject(huffmanCodes);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			try {
				is.close();
				oos.close();
				os.close();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
	}
	private static byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes){
		    //用来获取huffmanCodes对应的二进制字符串
		    StringBuilder stringBuilder1 = new StringBuilder();
		    //将byte转换成字符串
		    for(int i=0;i<huffmanBytes.length;i++){
		    	byte b=huffmanBytes[i];
		    	boolean flag=(i==huffmanBytes.length-1);
		    	stringBuilder1.append(byteToBitString(!flag, b));
		    }
			//把字符串安装指定的赫夫曼编码进行解码
			//把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
		    Map<String, Byte> map=new HashMap();
		    for(Map.Entry<Byte, String> enty:huffmanCodes.entrySet()){
		    	map.put(enty.getValue(), enty.getKey());
		    }
		    //创建集合 存放byte
		    List<Byte> list = new ArrayList<>();
		    for(int i=0;i<stringBuilder1.length();){
		    	//定义计数器
		    	int count=1;
		    	boolean flag=true;
		    	Byte b=null;
		    	while(flag){
		    		String key=stringBuilder1.substring(i,i+count);
		    		b=map.get(key);
		    		if(b==null){
		    			count++;
		    		}else{
		    			flag=false;
		    		}
		    	}
		    	list.add(b);
		    	i+=count;
		    }
		  //当for循环结束后，我们list中就存放了所有的字符  "i like like like java do you like a java"
			//把list 中的数据放入到byte[] 并返回
			byte b[] = new byte[list.size()];
			for(int i = 0;i < b.length; i++) {
				b[i] = list.get(i);
			}
			return b;
		
	}
	//将byte转换成一个二进制字符串
	//如果是正数需要补高位 最后一个数无需补高位 （采用flag用来判断）
	private static String byteToBitString(boolean flag, byte b) {
		//使用变量保存 b
		int temp = b; //将 b 转成 int
		//如果是正数我们还存在补高位
		if(flag) {
			temp |= 256; //按位与 256  1 0000 0000  | 0000 0001 => 1 0000 0001
			//负数保持不变
		}
		String str = Integer.toBinaryString(temp); //返回的是temp对应的二进制的补码
		if(flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}
	}
	private static byte[] huffmanZip(byte[] bytes) {
		List<Nodee> nodes = getNodes(bytes);
		// 根据 nodes 创建的赫夫曼树
		Nodee huffmanTreeRoot = createHuffmanTree(nodes);
		// 对应的赫夫曼编码(根据 赫夫曼树)
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		// 根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
		return huffmanCodeBytes;
	}
	//将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes){
		//1.利用 huffmanCodes 将  bytes 转成  赫夫曼编码对应的字符串
		StringBuilder stringBuilder = new StringBuilder();
		// 遍历bytes 数组
		for (byte b : bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}
		int len;
		if(stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length() / 8;
		} else {
			len = stringBuilder.length() / 8 + 1;
		}
		//创建 存储压缩后的 byte数组
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;//记录是第几个byte
		for (int i = 0; i < stringBuilder.length(); i += 8) { //因为是每8位对应一个byte,所以步长 +8
			String strByte;
			if(i+8 > stringBuilder.length()) {//不够8位
				strByte = stringBuilder.substring(i);
			}else{
				strByte = stringBuilder.substring(i, i + 8);
			}	
			//将strByte 转成一个byte,放入到 huffmanCodeBytes 负数通过补码存储  负数补码等于反码+1
			huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);
			index++;
	}
	return huffmanCodeBytes;
		
	}
	
	//生成赫夫曼树对应的赫夫曼编码
	//思路:
	//1. 将赫夫曼编码表存放在 Map<Byte,String> 形式
	//   生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
	static Map<Byte, String> huffmanCodes = new HashMap<Byte,String>();
	//2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
	static StringBuilder stringBuilder = new StringBuilder();
	//为了调用方便，我们重载 getCodes
	private static Map<Byte, String> getCodes(Nodee root) {
		if(root == null) {
			return null;
		}
		//处理root的左子树
		getCodes(root.left, "0", stringBuilder);
		//处理root的右子树
		getCodes(root.right, "1", stringBuilder);
		return huffmanCodes;
	}
	
	/**
	 * 功能：将传入的node结点的所有叶子结点的赫夫曼编码得到，并放入到huffmanCodes集合
	 * @param node  传入结点
	 * @param code  路径： 左子结点是 0, 右子结点 1
	 * @param stringBuilder 用于拼接路径
	 */
	private static void getCodes(Nodee node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		//将code 加入到 stringBuilder2
		stringBuilder2.append(code);
		if(node != null) { //如果node == null不处理
			//判断当前node 是叶子结点还是非叶子结点
			if(node.data == null) { //非叶子结点
				//递归处理
				//向左递归
				getCodes(node.left, "0", stringBuilder2);
				//向右递归
				getCodes(node.right, "1", stringBuilder2);
			} else { //说明是一个叶子结点
				//就表示找到某个叶子结点的最后
				huffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}
	
    //获取需要的list
	private static List<Nodee> getNodes(byte[] bytes){
		 ArrayList<Nodee> nodees = new ArrayList<Nodee>();
		 //采用map记录数值
		 Map<Byte, Integer> map = new HashMap<>();
		 for(Byte temp:bytes){
			 Integer count=map.get(temp);
			 if(count==null){
				 map.put(temp, 1);
			 }else{
				 map.put(temp, count+1);
			 }
		 }
		 //创建node节点 遍历map
		for(Map.Entry<Byte, Integer> entry : map.entrySet()){
			nodees.add(new Nodee(entry.getKey(),entry.getValue()));
		}
		return nodees;
	}
	
	//可以通过List 创建对应的赫夫曼树
		private static Nodee createHuffmanTree(List<Nodee> nodes) {
			
			while(nodes.size() > 1) {
				//排序, 从小到大
				Collections.sort(nodes);
				//取出第一颗最小的二叉树
				Nodee leftNode = nodes.get(0);
				//取出第二颗最小的二叉树
				Nodee rightNode = nodes.get(1);
				//创建一颗新的二叉树,它的根节点 没有data, 只有权值
				Nodee parent = new Nodee(null, leftNode.weight + rightNode.weight);
				parent.left = leftNode;
				parent.right = rightNode;
				
				//将已经处理的两颗二叉树从nodes删除
				nodes.remove(leftNode);
				nodes.remove(rightNode);
				//将新的二叉树，加入到nodes
				nodes.add(parent);
				
			}
			//nodes 最后的结点，就是赫夫曼树的根结点
			return nodes.get(0);
			
		}
	
	
}

//创建Node ,待数据和权值
class Nodee implements Comparable<Nodee>  {
	Byte data; // 存放数据(字符)本身，比如'a' => 97 ' ' => 32
	int weight; //权值, 表示字符出现的次数
	Nodee left;//
	Nodee right;
	public Nodee(Byte data, int weight) {
		
		this.data = data;
		this.weight = weight;
	}
	@Override
	public int compareTo(Nodee o) {
		// 从小到大排序
		return this.weight - o.weight;
	}
	
	public String toString() {
		return "Nodee [data = " + data + " weight=" + weight + "]";
	}
	
	//前序遍历
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
}
