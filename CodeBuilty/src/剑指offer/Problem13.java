package 剑指offer;
/**
 * 题目：给定单向链表的头指针和一个节点指针，定义一个函数在O（1）时间删除该节点
 * @author caojuan 16-5-15
 *
 */
public class Problem13 {
	//单向链表
	public static class ListNode1{
		int value;
		ListNode1 next;
	}
	/**
	 * 删除节点的函数
	 * @param Head 头节点
	 * @param toBeDeleted 将要删除的节点
	 */
	public void DeleteNode(ListNode1 Head,ListNode1 toBeDeleted){
		if (Head==null||toBeDeleted==null) {
			System.out.println("头节点为空");
			return;
		}
		/*
		 * 将要删除节点i的下一个节点j的值覆盖i，
		 * 将i指向k,然后删除j节点
		 */
		//要删除的节点不是尾节点
		if (toBeDeleted.next!=null) {
			ListNode1 nextNode=toBeDeleted.next;
			toBeDeleted.value=nextNode.value;
			toBeDeleted.next=nextNode.next;
			nextNode=null;
		}
		//要删除的链表中只有一个节点
		else if (Head==toBeDeleted) {
			toBeDeleted=null;
			Head=null;
		}
		//链表节点不止一个，要删除尾节点
		if (toBeDeleted.next==null) {
			ListNode1 nextNode=Head;
			//找待删除节点的前一个节点
			while(nextNode.next!=toBeDeleted){
				nextNode=nextNode.next;
			}
			nextNode.next=null;
		} 
	}
	public void printListNode(ListNode1 head){
		while(head!=null){
			System.out.print(head.value+"->");
			head=head.next;
		}
		System.out.println("null");
	}
	public static void main(String []args){
		Problem13 test=new Problem13();
		ListNode1 head=new ListNode1();
		ListNode1 listNode1 = new ListNode1();
		ListNode1 listNode2=new ListNode1();
		ListNode1 listNode3=new ListNode1();
		ListNode1 listNode4=new ListNode1();
		ListNode1 listNode5=new ListNode1();
		ListNode1 listNode6=new ListNode1();
		ListNode1 listNode7=new ListNode1();
		ListNode1 listNode8=new ListNode1();
		ListNode1 listNode9=new ListNode1();
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
		listNode9=null;
		//完整链表
		test.printListNode(head);
		//在有多个节点的链表中删除头节点
		test.DeleteNode(head, head);
		test.printListNode(head);
		//在有多个节点的链表中间删除一个节点
		test.DeleteNode(head, listNode3);
		test.printListNode(head);
		//在有多个节点的链表中删除尾节点
		test.DeleteNode(head, listNode8);
		test.printListNode(head);
		//删除空链表节点--特殊测试
		test.DeleteNode(listNode9, listNode9);
	}
}
