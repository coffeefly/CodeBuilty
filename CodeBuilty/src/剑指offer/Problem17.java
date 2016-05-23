package ��ָoffer;

/**
 * ��Ŀ�����������������������
 * �ϲ�����������ʹ�������еĽڵ���Ȼ�ǰ��յ��������
 * @author caojuan 16-5-18
 *
 */
public class Problem17 {
	public static class ListNode{
		int key;
		ListNode next;
	}
	/**
	 * �ϲ������������������
	 * @param head1 
	 * @param head2
	 * @return ���غϲ����������
	 */
	public ListNode Merge(ListNode head1,ListNode head2){
		//����head1����head2Ϊ�յ����
		if (head1==null) {
			return head2;
		}
		else if(head2==null){
			return head1;
		}
		ListNode MergeHead=null;
		//�ϲ��Ĺ���
		if (head1.key<head2.key) {
			MergeHead=head1;
			MergeHead.next=Merge(head1.next, head2);
		}
		else {
			MergeHead=head2;
			MergeHead.next=Merge(head1, head2.next);
		}
		return MergeHead;
	}
	/**
	 * ��������нڵ��ֵ
	 * @param head ����ͷ�ڵ�
	 */
	public void printNode(ListNode head){
		if (head==null) {
			System.out.println("����Ϊ��");
		}
		while(head!=null){
			System.out.print(head.key+" ");
			head=head.next;
		}
		System.out.println();
	}
	public static void main(String []args){
		Problem17 test=new Problem17();
		ListNode head1=new ListNode();
		ListNode head2=new ListNode();
		ListNode listNode1=new ListNode();
		ListNode listNode2=new ListNode();
		ListNode listNode3=new ListNode();
		ListNode listNode4=new ListNode();
		ListNode listNode5=new ListNode();
		head1.key=1;
		head1.next=listNode1;
		listNode1.key=3;
		listNode1.next=listNode2;
		listNode2.key=5;
		listNode2.next=null;
		head2.key=2;
		head2.next=listNode3;
		listNode3.key=4;
		listNode3.next=null;
		listNode4.key=6;
		listNode4.next=null;
		listNode5.key=7;
		listNode5.next=null;
		test.printNode(test.Merge(head2, null));
		test.printNode(test.Merge(head1, head2));
		test.printNode(test.Merge(listNode4, listNode5));
		test.printNode(test.Merge(null, null));
		
	}
}
