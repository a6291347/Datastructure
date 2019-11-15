package com.hzh.linkedlist;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
		
		//����Ҫ������
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		
		//����
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);
		singleLinkedList.list();
	}
	
}
	
class SingleLinkedList{
	//����ͷ�ڵ�
	private HeroNode head=new HeroNode(0, "", "");
	//����ͷ���
	public HeroNode  getHead() {
		return head;
	}
	//���Ӣ�۵�����
	public void add(HeroNode hd){
		//���һ�������ڵ�
		HeroNode temp=head;
		while(true){
			if(temp.next==null){
				break;
			}
			temp=temp.next;
		}
		temp.next=hd;
	}
	public void list(){
		//�ж������Ƿ�Ϊ��
		if(head.next==null){
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp=head.next;
		while(true){
			if(temp==null){
				break;
			}
			System.out.println(temp.toString());
			temp=temp.next;
		}
	}
	
}
	
	
	
	
class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next; //ָ����һ���ڵ�
	//������
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	//Ϊ����ʾ��������������toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}


