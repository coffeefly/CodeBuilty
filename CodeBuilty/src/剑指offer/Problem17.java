package 剑指offer;

/**
 * 题目：输入两个递增排序的链表，
 * 合并这两个链表并使新链表中的节点仍然是按照递增排序的
 * @author caojuan 16-5-18
 *
 */
public class Problem17 {
	public static class ListNode{
		int key;
		ListNode next;
	}
	/**
	 * 合并两个递增排序的链表
	 * @param head1 
	 * @param head2
	 * @return 返回合并后的新链表
	 */
	public ListNode Merge(ListNode head1,ListNode head2){
		//考虑head1或者head2为空的情况
		if (head1==null) {
			return head2;
		}
		else if(head2==null){
			return head1;
		}
		ListNode MergeHead=null;
		//合并的过程
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
	 * 输出链表中节点的值
	 * @param head 链表头节点
	 */
	public void printNode(ListNode head){
		if (head==null) {
			System.out.println("链表为空");
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
