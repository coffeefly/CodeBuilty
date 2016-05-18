package 剑指offer;

import 剑指offer.Problem15.ListNode2;

/**
 * 题目：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
 * @author caojuan 16-5-17
 *
 */
public class Problem16 {
	public static class ListNode{
		int key;
		ListNode next;
	}
	public ListNode ReverseList(ListNode Head){
		if (Head==null) {
			System.out.println("当前链表为空");
			return null;
		}
		//反转后的头节点
		ListNode ReversedHead=null;
		//当前结点
		ListNode Node=Head;
		//当前结点的前一个节点
		ListNode Prev=null;
		while(Node!=null){
			ListNode Next=Node.next;
			if (Next==null) {
				ReversedHead=Node;
			}
			Node.next=Prev;
			Prev=Node;
			Node=Next;
		}
		System.out.println(ReversedHead.key);
		return ReversedHead;
	}
	public static void main(String []args){
		Problem16 test=new Problem16();
		ListNode head=new ListNode();
		ListNode listNode1=new ListNode();
		ListNode listNode2=new ListNode();
		ListNode listNode3=new ListNode();
		ListNode listNode4=new ListNode();
		ListNode listNode5=new ListNode();
		ListNode listNode6=new ListNode();
		ListNode listNode7=new ListNode();
		ListNode listNode8=new ListNode();
		head.key=1;
		head.next=listNode1;
		listNode1.key=2;
		listNode1.next=listNode2;
		listNode2.key=3;
		listNode2.next=listNode3;
		listNode3.key=4;
		listNode3.next=listNode4;
		listNode4.key=5;
		listNode4.next=listNode5;
		listNode5.key=6;
		listNode5.next=listNode6;
		listNode6.key=7;
		listNode6.next=listNode7;
		listNode7.key=8;
		listNode7.next=listNode8;
		listNode8.key=9;
		listNode8.next=null;
		//test
		test.ReverseList(head);
	}
}
