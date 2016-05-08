package 剑指offer;

import java.util.Stack;

/**
 * 用两个栈模仿队列
 * @author caojuan 16-5-7
 *
 */
public class CQueue {
	private Stack<Object> stack1=new Stack<Object>();
	private Stack<Object> stack2=new Stack<Object>();
	//插入尾节点
	public void appendTail(Object element){
		stack1.push(element);
		System.out.println(element);
	}
	//删除头节点
	public Object deleteHead() throws Exception{
		if (stack2.size()<=0) {
			while(stack1.size()>0){
				Object data=stack1.firstElement();
				stack1.pop();
				stack2.push(data);
			}
		}
		if (stack2.size()==0) {
			throw new Exception("Queue is empty");
		}
		Object Head=stack2.firstElement();
		stack2.pop();
		System.out.println("删除的节点值："+Head);
		return Head;
	}
	public static void main(String []args) throws Exception{
		CQueue cQueue=new CQueue();
		int i=0;
		while(i<5){
			cQueue.appendTail(i+2);
			cQueue.deleteHead();
			i++;
		}
	}
}
