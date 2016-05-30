package ��ָoffer;

import java.util.Stack;

/**
 * ��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min������
 * ����min,push,pop��ʱ�临�Ӷȶ���O(1)
 * @author caojuan
 *
 */
public class Problem21 {
	public static class StackWithMin<T extends Comparable<T>>{
		private Stack<T> dataStack;
		private Stack<Integer> minStack;
		//���캯��
		public StackWithMin(){
			this.dataStack=new Stack<>();
			this.minStack=new Stack<>();
		}
		//��ջ
		public void pop(){
			if (dataStack.isEmpty()) {
				throw new RuntimeException("the Stack is empty.");
			}
			dataStack.pop();
			minStack.pop();
		}
		//��ջ
		public void push(T t){
			if (t==null) {
				throw new RuntimeException("Element can be null");
			}
			//����ջΪ��
			if (dataStack.isEmpty()) {
				dataStack.push(t);
				minStack.push((Integer) t);
			}
		}
	}
}
