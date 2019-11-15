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
		
		//���� 
		byte[] decode = decode(huffmanCodes, huffmanZip);
		System.out.println(new String(decode));*/
	/*	String zipFile = "C://JavaTestDome/src.bmp";
		String dstFile = "C://JavaTestDome/src2.zip";
		zipFile(zipFile, dstFile);
		System.out.println("ѹ���ɹ�");*/
		String zipFile = "C://JavaTestDome/src2.zip";
		String dstFile = "C://JavaTestDome/src3.bmp";
		unZipFile(zipFile, dstFile);
		System.out.println("��ѹ�ɹ�");
	}
	//��дһ����������ɶ�ѹ���ļ��Ľ�ѹ
public static void unZipFile(String zipFile, String dstFile) {
		
		//�����ļ�������
		InputStream is = null;
		//����һ������������
		ObjectInputStream ois = null;
		//�����ļ��������
		OutputStream os = null;
		try {
			//�����ļ�������
			is = new FileInputStream(zipFile);
			//����һ����  is�����Ķ���������
			ois = new ObjectInputStream(is);
			//��ȡbyte����  huffmanBytes
			byte[] huffmanBytes = (byte[])ois.readObject();
			//��ȡ�շ��������
			Map<Byte,String> huffmanCodes = (Map<Byte,String>)ois.readObject();
			
			//����
			byte[] bytes = decode(huffmanCodes, huffmanBytes);
			//��bytes ����д�뵽Ŀ���ļ�
			os = new FileOutputStream(dstFile);
			//д���ݵ� dstFile �ļ�
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
	
	
	//��д��������һ���ļ�����ѹ��
public static void zipFile(String srcFile, String dstFile) {
		//���������
		OutputStream os = null;
		ObjectOutputStream oos = null;
		//�����ļ���������
		FileInputStream is = null;
		try {
			//�����ļ���������
			is = new FileInputStream(srcFile);
			//����һ����Դ�ļ���Сһ����byte[]
			byte[] b = new byte[is.available()];
			//��ȡ�ļ�
			is.read(b);
			//ֱ�Ӷ�Դ�ļ�ѹ��
			byte[] huffmanBytes = huffmanZip(b);
			//�����ļ��������, ���ѹ���ļ�
			os = new FileOutputStream(dstFile);
			//����һ�����ļ������������ObjectOutputStream
			oos = new ObjectOutputStream(os);
			//�� �շ����������ֽ�����д��ѹ���ļ�
			oos.writeObject(huffmanBytes); 
			//���������Զ������ķ�ʽд�� �շ������룬��Ϊ���Ժ����ǻָ�Դ�ļ�ʱʹ��
			//ע��һ��Ҫ�Ѻշ������� д��ѹ���ļ�
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
		    //������ȡhuffmanCodes��Ӧ�Ķ������ַ���
		    StringBuilder stringBuilder1 = new StringBuilder();
		    //��byteת�����ַ���
		    for(int i=0;i<huffmanBytes.length;i++){
		    	byte b=huffmanBytes[i];
		    	boolean flag=(i==huffmanBytes.length-1);
		    	stringBuilder1.append(byteToBitString(!flag, b));
		    }
			//���ַ�����װָ���ĺշ���������н���
			//�Ѻշ����������е�������Ϊ�����ѯ a->100 100->a
		    Map<String, Byte> map=new HashMap();
		    for(Map.Entry<Byte, String> enty:huffmanCodes.entrySet()){
		    	map.put(enty.getValue(), enty.getKey());
		    }
		    //�������� ���byte
		    List<Byte> list = new ArrayList<>();
		    for(int i=0;i<stringBuilder1.length();){
		    	//���������
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
		  //��forѭ������������list�оʹ�������е��ַ�  "i like like like java do you like a java"
			//��list �е����ݷ��뵽byte[] ������
			byte b[] = new byte[list.size()];
			for(int i = 0;i < b.length; i++) {
				b[i] = list.get(i);
			}
			return b;
		
	}
	//��byteת����һ���������ַ���
	//�����������Ҫ����λ ���һ�������貹��λ ������flag�����жϣ�
	private static String byteToBitString(boolean flag, byte b) {
		//ʹ�ñ������� b
		int temp = b; //�� b ת�� int
		//������������ǻ����ڲ���λ
		if(flag) {
			temp |= 256; //��λ�� 256  1 0000 0000  | 0000 0001 => 1 0000 0001
			//�������ֲ���
		}
		String str = Integer.toBinaryString(temp); //���ص���temp��Ӧ�Ķ����ƵĲ���
		if(flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}
	}
	private static byte[] huffmanZip(byte[] bytes) {
		List<Nodee> nodes = getNodes(bytes);
		// ���� nodes �����ĺշ�����
		Nodee huffmanTreeRoot = createHuffmanTree(nodes);
		// ��Ӧ�ĺշ�������(���� �շ�����)
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		// �������ɵĺշ������룬ѹ���õ�ѹ����ĺշ��������ֽ�����
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
		return huffmanCodeBytes;
	}
	//���ַ�����Ӧ��byte[] ���飬ͨ�����ɵĺշ������������һ���շ������� ѹ�����byte[]
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes){
		//1.���� huffmanCodes ��  bytes ת��  �շ��������Ӧ���ַ���
		StringBuilder stringBuilder = new StringBuilder();
		// ����bytes ����
		for (byte b : bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}
		int len;
		if(stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length() / 8;
		} else {
			len = stringBuilder.length() / 8 + 1;
		}
		//���� �洢ѹ����� byte����
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;//��¼�ǵڼ���byte
		for (int i = 0; i < stringBuilder.length(); i += 8) { //��Ϊ��ÿ8λ��Ӧһ��byte,���Բ��� +8
			String strByte;
			if(i+8 > stringBuilder.length()) {//����8λ
				strByte = stringBuilder.substring(i);
			}else{
				strByte = stringBuilder.substring(i, i + 8);
			}	
			//��strByte ת��һ��byte,���뵽 huffmanCodeBytes ����ͨ������洢  ����������ڷ���+1
			huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);
			index++;
	}
	return huffmanCodeBytes;
		
	}
	
	//���ɺշ�������Ӧ�ĺշ�������
	//˼·:
	//1. ���շ������������ Map<Byte,String> ��ʽ
	//   ���ɵĺշ��������{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
	static Map<Byte, String> huffmanCodes = new HashMap<Byte,String>();
	//2. �����ɺշ��������ʾ����Ҫȥƴ��·��, ����һ��StringBuilder �洢ĳ��Ҷ�ӽ���·��
	static StringBuilder stringBuilder = new StringBuilder();
	//Ϊ�˵��÷��㣬�������� getCodes
	private static Map<Byte, String> getCodes(Nodee root) {
		if(root == null) {
			return null;
		}
		//����root��������
		getCodes(root.left, "0", stringBuilder);
		//����root��������
		getCodes(root.right, "1", stringBuilder);
		return huffmanCodes;
	}
	
	/**
	 * ���ܣ��������node��������Ҷ�ӽ��ĺշ�������õ��������뵽huffmanCodes����
	 * @param node  ������
	 * @param code  ·���� ���ӽ���� 0, ���ӽ�� 1
	 * @param stringBuilder ����ƴ��·��
	 */
	private static void getCodes(Nodee node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		//��code ���뵽 stringBuilder2
		stringBuilder2.append(code);
		if(node != null) { //���node == null������
			//�жϵ�ǰnode ��Ҷ�ӽ�㻹�Ƿ�Ҷ�ӽ��
			if(node.data == null) { //��Ҷ�ӽ��
				//�ݹ鴦��
				//����ݹ�
				getCodes(node.left, "0", stringBuilder2);
				//���ҵݹ�
				getCodes(node.right, "1", stringBuilder2);
			} else { //˵����һ��Ҷ�ӽ��
				//�ͱ�ʾ�ҵ�ĳ��Ҷ�ӽ������
				huffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}
	
    //��ȡ��Ҫ��list
	private static List<Nodee> getNodes(byte[] bytes){
		 ArrayList<Nodee> nodees = new ArrayList<Nodee>();
		 //����map��¼��ֵ
		 Map<Byte, Integer> map = new HashMap<>();
		 for(Byte temp:bytes){
			 Integer count=map.get(temp);
			 if(count==null){
				 map.put(temp, 1);
			 }else{
				 map.put(temp, count+1);
			 }
		 }
		 //����node�ڵ� ����map
		for(Map.Entry<Byte, Integer> entry : map.entrySet()){
			nodees.add(new Nodee(entry.getKey(),entry.getValue()));
		}
		return nodees;
	}
	
	//����ͨ��List ������Ӧ�ĺշ�����
		private static Nodee createHuffmanTree(List<Nodee> nodes) {
			
			while(nodes.size() > 1) {
				//����, ��С����
				Collections.sort(nodes);
				//ȡ����һ����С�Ķ�����
				Nodee leftNode = nodes.get(0);
				//ȡ���ڶ�����С�Ķ�����
				Nodee rightNode = nodes.get(1);
				//����һ���µĶ�����,���ĸ��ڵ� û��data, ֻ��Ȩֵ
				Nodee parent = new Nodee(null, leftNode.weight + rightNode.weight);
				parent.left = leftNode;
				parent.right = rightNode;
				
				//���Ѿ���������Ŷ�������nodesɾ��
				nodes.remove(leftNode);
				nodes.remove(rightNode);
				//���µĶ����������뵽nodes
				nodes.add(parent);
				
			}
			//nodes ���Ľ�㣬���Ǻշ������ĸ����
			return nodes.get(0);
			
		}
	
	
}

//����Node ,�����ݺ�Ȩֵ
class Nodee implements Comparable<Nodee>  {
	Byte data; // �������(�ַ�)��������'a' => 97 ' ' => 32
	int weight; //Ȩֵ, ��ʾ�ַ����ֵĴ���
	Nodee left;//
	Nodee right;
	public Nodee(Byte data, int weight) {
		
		this.data = data;
		this.weight = weight;
	}
	@Override
	public int compareTo(Nodee o) {
		// ��С��������
		return this.weight - o.weight;
	}
	
	public String toString() {
		return "Nodee [data = " + data + " weight=" + weight + "]";
	}
	
	//ǰ�����
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
