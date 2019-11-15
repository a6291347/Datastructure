package com.hzh.linkedlist;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		
		//创建要给链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		
		//加入
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);
		singleLinkedList.list();
	}
	
}
	
class SingleLinkedList{
	//定义头节点
	private HeroNode head=new HeroNode(0, "", "");
	//返回头结点
	public HeroNode  getHead() {
		return head;
	}
	//添加英雄到链表
	public void add(HeroNode hd){
		//添加一个辅助节点
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
		//判断链表是否为空
		if(head.next==null){
			System.out.println("链表为空");
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
	public HeroNode next; //指向下一个节点
	//构造器
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	//为了显示方法，我们重新toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}


