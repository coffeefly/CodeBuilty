package 剑指offer;

/**
 * 题目：输入一个链表，输出该链表中倒数第K个节点
 * @author caojuan 16-5-15
 *
 */
public class Problem15 {
	//单向链表
	public static class ListNode2{
		int value;
		ListNode2 next;
	}
	/**
	 * 要考虑鲁棒性
	 * @param head 链表头节点
	 * @param k 从1开始算起
	 * @return 倒数第K个节点
	 */
	public ListNode2 FindKthToTail(ListNode2 Listhead,int k){
		if (Listhead==null||k==0) {
			return null;
		}
		ListNode2 head=Listhead;
		ListNode2 behind=null;
		for(int i=0;i<k-1;i++){
			if (head.next!=null) {
				head=head.next;
			}
			else{
				return null;
			}
		}
		behind=Listhead;
		while(head.next!=null){
			head=head.next;
			behind=behind.next;
		}
		System.out.println(behind.value);
		return behind;
	}
	public static void mian(String []args){
		Problem15 test=new Problem15();
		ListNode2 head=new ListNode2();
		ListNode2 listNode1 = new ListNode2();
		ListNode2 listNode2=new ListNode2();
		ListNode2 listNode3=new ListNode2();
		ListNode2 listNode4=new ListNode2();
		ListNode2 listNode5=new ListNode2();
		ListNode2 listNode6=new ListNode2();
		ListNode2 listNode7=new ListNode2();
		ListNode2 listNode8=new ListNode2();
		head.value=1;
		head.next=listNode1;
		listNode1.value=2;
		listNode1.next=listNode2;
		listNode2.value=3;
		listNode2.next=listNode3;
		listNode3.value=4;
		listNode3.next=listNode4;
		listNode4.value=5;
		listNode4.next=listNode5;
		listNode5.value=6;
		listNode5.next=listNode6;
		listNode6.value=7;
		listNode6.next=listNode7;
		listNode7.value=8;
		listNode7.next=listNode8;
		listNode8.value=9;
		listNode8.next=null;
		test.FindKthToTail(head, 3);
		System.out.println("problem15");
	}
}
