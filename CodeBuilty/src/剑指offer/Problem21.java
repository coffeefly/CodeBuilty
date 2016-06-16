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
			//����ջΪ�գ���������ջ��ͬʱ������С����ջ�е�����
			if (dataStack.isEmpty()) {
				dataStack.push(t);
				minStack.push(0);
			}
			//�������ջ��������
			else{
				//��ȡ����ջ�е���Сֵ,δ����t֮ǰ��
				T e=dataStack.get(minStack.peek());
				//��t��ջ
				dataStack.push(t);
				//�����������ݱ�����ջ����СԪ��С
				if (t.compareTo(e)<0) {
					minStack.push(dataStack.size()-1);
				}
				else
				{
					//������Сջջ��Ԫ�أ�������ջ
					minStack.push(minStack.peek());
				}
			}
		}
		//�õ�ջ����СԪ��
		public T min(){
			//�����СջΪ�գ����׳��쳣
			if(minStack.isEmpty()){
				throw new RuntimeException("There is No Element in Stack");
			}
			return dataStack.get(minStack.peek());
		}
	}
	
	public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }
}
