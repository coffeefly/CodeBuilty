package 剑指offer; 	
import java.util.Stack;

/**
 * 从尾到头打印链表
 * @author caojuan 16-5-4
 *
 */
public class PrintListReversingly_Iteratively {
	public static class ListNode {
		int data;
		ListNode next;
	}
	
	public void Print_Iteratively(ListNode headNode){
		Stack<ListNode> stack=new Stack<ListNode>();
		ListNode pNode=headNode;
		while(pNode!=null){
			stack.push(pNode);
			pNode=pNode.next;
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop().data);
		}
	}
	
	public void Print_Recursively(ListNode headNode){
		if (headNode!=null) {
			if (headNode.next!=null) {
				Print_Recursively(headNode.next);
			}
			System.out.println(headNode.data);
		}
	}
	
	public static void main(String []args){
		ListNode first=new ListNode();
		ListNode second=new ListNode();
		ListNode third=new ListNode();
		ListNode four=new ListNode();
		first.data=1;
		first.next=second;
		second.data=2;
		second.next=third;
		third.data=3;
		third.next=four;
		four.data=4;
		four.next=null;
		PrintListReversingly_Iteratively problem5=new PrintListReversingly_Iteratively();
		System.out.println("栈：");
		problem5.Print_Iteratively(second);
		System.out.println("递归：");
		problem5.Print_Recursively(third);
	}
}
