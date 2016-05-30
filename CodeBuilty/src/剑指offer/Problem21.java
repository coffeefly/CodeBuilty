package 剑指offer;

import java.util.Stack;

/**
 * 题目：定义栈的数据结构，请在该类型中实现一个能过得到栈的最小元素的min函数，
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
			//数据栈为空
			if (dataStack.isEmpty()) {
				dataStack.push(t);
				minStack.push((Integer) t);
			}
		}
	}
}
