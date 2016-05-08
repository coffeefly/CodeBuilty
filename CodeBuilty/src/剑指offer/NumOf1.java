package 剑指offer;

import java.util.zip.Inflater;

/**
 * 二进制中1的个数
 * @author caojuan 16-5=8
 *
 */
/*
输入一个整数，输出该数二进制表示中的１的个数
结论：把一个整数减去１再和原整数与，就会把整数最右边一个１变成０
 */

public class NumOf1 {
	//最佳算法
	public int numOf1(int n){
		int count=0;
		while(n!=0){
			n=(n-1)&n;
			count++;
		}
		System.out.println(count);
		return count;
	}
	//遇到负数崩溃算法
	public int numOf12(int n){
		int count=0;
		while(n!=0){
			if ((n&1)==1) {
				count++;
			}
			n=n>>1;
		}
		System.out.println(count);
		return count;
	}
	public static void main(String []args){
		NumOf1 problem10=new NumOf1();
		problem10.numOf1(0);
		//problem10.numOf12(0x80000000);死循环
	}
}


