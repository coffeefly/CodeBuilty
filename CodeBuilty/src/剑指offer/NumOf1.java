package ��ָoffer;

import java.util.zip.Inflater;

/**
 * ��������1�ĸ���
 * @author caojuan 16-5=8
 *
 */
/*
����һ��������������������Ʊ�ʾ�еģ��ĸ���
���ۣ���һ��������ȥ���ٺ�ԭ�����룬�ͻ���������ұ�һ������ɣ�
 */

public class NumOf1 {
	//����㷨
	public int numOf1(int n){
		int count=0;
		while(n!=0){
			n=(n-1)&n;
			count++;
		}
		System.out.println(count);
		return count;
	}
	//�������������㷨
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
		//problem10.numOf12(0x80000000);��ѭ��
	}
}


