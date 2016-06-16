package 剑指offer;

import java.util.Stack;

/**
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数，
 * 调用min,push,pop的时间复杂度都是O(1)
 * @author caojuan
 *
 */
public class Problem21 {
	public static class StackWithMin<T extends Comparable<T>>{
		private Stack<T> dataStack;
		private Stack<Integer> minStack;
		//构造函数
		public StackWithMin(){
			this.dataStack=new Stack<>();
			this.minStack=new Stack<>();
		}
		//出栈
		public void pop(){
			if (dataStack.isEmpty()) {
				throw new RuntimeException("the Stack is empty.");
			}
			dataStack.pop();
			minStack.pop();
		}																																																																																																																																																																																																																																																																																																																																														  
		//入栈
		public void push(T t){
			if (t==null) {
				throw new RuntimeException("Element can be null");
			}
			//数据栈为空，则将数据入栈，同时更新最小数据栈中的数据
			if (dataStack.isEmpty()) {
				dataStack.push(t);
				minStack.push(0);
			}
			//如果数据栈中有数据
			else{
				//获取数据栈中的最小值,未插入t之前的
				T e=dataStack.get(minStack.peek());
				//将t入栈
				dataStack.push(t);
				//如果插入的数据比数据栈中最小元素小
				if (t.compareTo(e)<0) {
					minStack.push(dataStack.size()-1);
				}
				else
				{
					//复制最小栈栈顶元素，将其入栈
					minStack.push(minStack.peek());
				}
			}
		}
		//得到栈的最小元素
		public T min(){
			//如果最小栈为空，则抛出异常
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
