package ��ָoffer;

/**
 * 쳲���������
 * @author caojuan 16-5-8
 * �������Ҳ�������쵽��������һ����һ������������n��̨������
 * f(n)=f(n-1)+f(n-2)
 */
public class Fibonacci {
	public long fibonacci(int n){
		int result[]={0,1};
		if (n<2) {
			System.out.println(result[n]);
			return result[n];
		}
		long fibOne=0;
		long fibTwo=1;
		long fibN=0;
		for(int i=2;i<=n;i++){
			fibN=fibOne+fibTwo;
			fibOne=fibTwo;
			fibTwo=fibN;
		}
		System.out.println(fibN);
		return fibN;
	}
	public static void main(String []args){
		Fibonacci fibonacci=new Fibonacci();
		fibonacci.fibonacci(100);
	}
}
