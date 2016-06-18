package 剑指offer;

import java.util.Stack;

/**
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的的弹出序列。假设压入栈的所有数字
 * 均不相等。例如1、2、3、4、5是某栈的压栈序列，序列4、5、3、2、1
 * 是该压栈序列对应的一个弹出序列，但4、3、5、1、2就不可能是该压栈序列的弹出序列
 * @author caojuan 2016-06-17
 *
 */
public class Problem22 {
	/**
	 * 判断第二个序列是否是第一个序列的弹出序列
	 * @param push 栈的压入序列
	 * @param pop  
	 * @return
	 */
	public boolean isPopOrder(int push[],int []pop){
		if (push==null||push.length==0||pop==null||pop.length==0||push.length!=pop.length) {
			return false;
		}
		//经过上面的判断可以保证两个数组均不为空而且数组长度相同，
		//但没有判断数组中的数字是否存在不相同的情况
		
		//定义一个辅助栈来存放入栈数据
		Stack<Integer> dataStack=new Stack<Integer>();
		//定义一个变量来存放入栈数据处理位置
		int pushIndex=0;
		//定义一个变量来存放出栈数据处理位置
		int popIndex=0;
		//如果还有出栈元素要处理
		while(popIndex<pop.length){
			//如果数据栈为空或者栈顶元素不是当前出栈元素则添加入栈元素
			while(pushIndex<push.length&&(dataStack.isEmpty()||dataStack.peek()!=pop[popIndex])){
				dataStack.push(push[pushIndex]);
				pushIndex++;
			}
			//如果在入栈元素中找到了与出栈元素相等的元素，则将该元素出栈
			if (dataStack.peek()==pop[popIndex]) {
				dataStack.pop();
				popIndex++;
			}
			else{
				return false;
			}
		}
		return true;
	}
	/**
	 * 方法2
	 * @param push 入栈序列
	 * @param pop 出栈序列
	 * @return
	 */
	public boolean isPopOrder2(int push[],int pop[]) {
		boolean possible=false;
		//如果入栈队列和出栈队列均不为空且入栈队列和出栈队列数组长度相同
		if (push!=null&&pop!=null&&push.length>0&&pop.length>0&&push.length==pop.length) {
			//定义一个辅助栈来存放入栈数据
			Stack<Integer> dataStack=new Stack<Integer>();
			//定义一个变量来存放入栈数据处理位置
			int nextPush=0;
			//定义一个变量来存放出栈数据处理位置
			int nextPop=0;
			//如果出栈元素没有处理完，就继续处理
			while(nextPop<pop.length){
				while(dataStack.isEmpty()||dataStack.peek()!=pop[nextPop]){
					//如果入栈元素全部入栈则退出循环
					if (nextPush==push.length) {
						break;
					}
					dataStack.push(push[nextPush]);
					nextPush++;
				}
				//如果在上层循环中没有找到了与出栈元素相等的元素
				if (dataStack.peek()!=pop[nextPop]) {
					//退出当前循环
					break;
				}
				
				dataStack.pop();
				//继续处理下一个出栈元素
				nextPop++;
			}
			//如果栈中的元素全部出栈
			if (dataStack.isEmpty()) {
				possible=true;
			}
		}
		return possible;
	}
	public static void main(String []args){
		Problem22 test=new Problem22();
		int push[]={1,2,3,4,5};
		int push1[]={6};
		int pop1[]={4,5,3,2,1};
		int pop2[]={4,5,3,1,2};
		int pop3[]={6};
		//方法1
		System.out.println("test1:"+test.isPopOrder(push, pop1));
		System.out.println("test2:"+test.isPopOrder(push, pop2));
		System.out.println("test3:"+test.isPopOrder(push, pop3));
		System.out.println("test4:"+test.isPopOrder(push1, pop3));
		System.out.println("test5:"+test.isPopOrder(null, null));
		//方法2
		System.out.println();
		System.out.println("test1:"+test.isPopOrder2(push, pop1));
		System.out.println("test2:"+test.isPopOrder2(push, pop2));
		System.out.println("test3:"+test.isPopOrder2(push, pop3));	
		System.out.println("test4:"+test.isPopOrder2(push1, pop3));
		System.out.println("test5:"+test.isPopOrder2(null, null));
	}
}
