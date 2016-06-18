package ��ָoffer;

import java.util.Stack;

/**
 * ��Ŀ�����������������У���һ�����б�ʾջ��ѹ��˳��
 * ���жϵڶ��������Ƿ�Ϊ��ջ�ĵĵ������С�����ѹ��ջ����������
 * ������ȡ�����1��2��3��4��5��ĳջ��ѹջ���У�����4��5��3��2��1
 * �Ǹ�ѹջ���ж�Ӧ��һ���������У���4��3��5��1��2�Ͳ������Ǹ�ѹջ���еĵ�������
 * @author caojuan 2016-06-17
 *
 */
public class Problem22 {
	/**
	 * �жϵڶ��������Ƿ��ǵ�һ�����еĵ�������
	 * @param push ջ��ѹ������
	 * @param pop  
	 * @return
	 */
	public boolean isPopOrder(int push[],int []pop){
		if (push==null||push.length==0||pop==null||pop.length==0||push.length!=pop.length) {
			return false;
		}
		//����������жϿ��Ա�֤�����������Ϊ�ն������鳤����ͬ��
		//��û���ж������е������Ƿ���ڲ���ͬ�����
		
		//����һ������ջ�������ջ����
		Stack<Integer> dataStack=new Stack<Integer>();
		//����һ�������������ջ���ݴ���λ��
		int pushIndex=0;
		//����һ����������ų�ջ���ݴ���λ��
		int popIndex=0;
		//������г�ջԪ��Ҫ����
		while(popIndex<pop.length){
			//�������ջΪ�ջ���ջ��Ԫ�ز��ǵ�ǰ��ջԪ���������ջԪ��
			while(pushIndex<push.length&&(dataStack.isEmpty()||dataStack.peek()!=pop[popIndex])){
				dataStack.push(push[pushIndex]);
				pushIndex++;
			}
			//�������ջԪ�����ҵ������ջԪ����ȵ�Ԫ�أ��򽫸�Ԫ�س�ջ
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
	 * ����2
	 * @param push ��ջ����
	 * @param pop ��ջ����
	 * @return
	 */
	public boolean isPopOrder2(int push[],int pop[]) {
		boolean possible=false;
		//�����ջ���кͳ�ջ���о���Ϊ������ջ���кͳ�ջ�������鳤����ͬ
		if (push!=null&&pop!=null&&push.length>0&&pop.length>0&&push.length==pop.length) {
			//����һ������ջ�������ջ����
			Stack<Integer> dataStack=new Stack<Integer>();
			//����һ�������������ջ���ݴ���λ��
			int nextPush=0;
			//����һ����������ų�ջ���ݴ���λ��
			int nextPop=0;
			//�����ջԪ��û�д����꣬�ͼ�������
			while(nextPop<pop.length){
				while(dataStack.isEmpty()||dataStack.peek()!=pop[nextPop]){
					//�����ջԪ��ȫ����ջ���˳�ѭ��
					if (nextPush==push.length) {
						break;
					}
					dataStack.push(push[nextPush]);
					nextPush++;
				}
				//������ϲ�ѭ����û���ҵ������ջԪ����ȵ�Ԫ��
				if (dataStack.peek()!=pop[nextPop]) {
					//�˳���ǰѭ��
					break;
				}
				
				dataStack.pop();
				//����������һ����ջԪ��
				nextPop++;
			}
			//���ջ�е�Ԫ��ȫ����ջ
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
		//����1
		System.out.println("test1:"+test.isPopOrder(push, pop1));
		System.out.println("test2:"+test.isPopOrder(push, pop2));
		System.out.println("test3:"+test.isPopOrder(push, pop3));
		System.out.println("test4:"+test.isPopOrder(push1, pop3));
		System.out.println("test5:"+test.isPopOrder(null, null));
		//����2
		System.out.println();
		System.out.println("test1:"+test.isPopOrder2(push, pop1));
		System.out.println("test2:"+test.isPopOrder2(push, pop2));
		System.out.println("test3:"+test.isPopOrder2(push, pop3));	
		System.out.println("test4:"+test.isPopOrder2(push1, pop3));
		System.out.println("test5:"+test.isPopOrder2(null, null));
	}
}
