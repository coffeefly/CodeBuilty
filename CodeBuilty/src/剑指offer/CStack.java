package ��ָoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����������ģ��ջ
 * 
 * @author caojuan 16-5-7
 *
 */

public class CStack {
	private Queue<Object> queue1 = new LinkedList<Object>();
	private Queue<Object> queue2 = new LinkedList<Object>();

	// ѹ��ڵ�
	public void appendTail(Object element) {
		queue1.add(element);
		System.out.println(element);
	}

	// ɾ��β�ڵ�
	public void deleteTail() throws Exception {
		if (queue1.size()>1&&queue2.size()<=0) {
			System.out.println("ɾ���ڵ㣺"+queue1.peek());
			while(queue1.size()>0){
				queue1.poll();
				Object data=queue1.peek();
				queue2.add(data);
			}
		}
		else if (queue2.size()>1&&queue1.size()<=0) {
			System.out.println("ɾ���ڵ㣺"+queue2.peek());
			while(queue2.size()>1){
				queue2.poll();
				Object data=queue2.peek();
				queue1.add(data);
			}
		}
		else if (queue1.size()==1) {
			System.out.println("ɾ���ڵ㣺"+queue1.peek());
			queue1.poll();
		} else {
			System.out.println("ɾ���ڵ㣺"+queue2.peek());
			queue2.poll();
		} 
	}
	public static void main(String []args) throws Exception{
		CStack cStack=new CStack();
		int i=0;
		while(i<5){
			cStack.appendTail(i+3);
			cStack.deleteTail();
			i++;
		}
	}
}
