package ��ָoffer;
/**
 * ��Ŀ���������������ͷָ���һ���ڵ�ָ�룬����һ��������O��1��ʱ��ɾ���ýڵ�
 * @author caojuan 16-5-15
 *
 */
public class Problem13 {
	//��������
	public static class ListNode1{
		int value;
		ListNode1 next;
	}
	/**
	 * ɾ���ڵ�ĺ���
	 * @param Head ͷ�ڵ�
	 * @param toBeDeleted ��Ҫɾ���Ľڵ�
	 */
	public void DeleteNode(ListNode1 Head,ListNode1 toBeDeleted){
		if (Head==null||toBeDeleted==null) {
			System.out.println("ͷ�ڵ�Ϊ��");
			return;
		}
		/*
		 * ��Ҫɾ���ڵ�i����һ���ڵ�j��ֵ����i��
		 * ��iָ��k,Ȼ��ɾ��j�ڵ�
		 */
		//Ҫɾ���Ľڵ㲻��β�ڵ�
		if (toBeDeleted.next!=null) {
			ListNode1 nextNode=toBeDeleted.next;
			toBeDeleted.value=nextNode.value;
			toBeDeleted.next=nextNode.next;
			nextNode=null;
		}
		//Ҫɾ����������ֻ��һ���ڵ�
		else if (Head==toBeDeleted) {
			toBeDeleted=null;
			Head=null;
		}
		//����ڵ㲻ֹһ����Ҫɾ��β�ڵ�
		if (toBeDeleted.next==null) {
			ListNode1 nextNode=Head;
			//�Ҵ�ɾ���ڵ��ǰһ���ڵ�
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
		//��������
		test.printListNode(head);
		//���ж���ڵ��������ɾ��ͷ�ڵ�
		test.DeleteNode(head, head);
		test.printListNode(head);
		//���ж���ڵ�������м�ɾ��һ���ڵ�
		test.DeleteNode(head, listNode3);
		test.printListNode(head);
		//���ж���ڵ��������ɾ��β�ڵ�
		test.DeleteNode(head, listNode8);
		test.printListNode(head);
		//ɾ��������ڵ�--�������
		test.DeleteNode(listNode9, listNode9);
	}
}
