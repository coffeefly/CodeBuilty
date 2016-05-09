package ��ָoffer;

/**
 * ����ֵ�������η�
 * @author caojuan 16-5-8
 *
 */
public class Power {
	public double power(double base,int exponent){
		if (equal(base,0.0)&&exponent<0) {
			System.out.println("��������!");
			return 0.0;
		}
		int absexponent=exponent;
		if (exponent<0) {
			absexponent=-exponent;
		}
		double result=1.0;
		for(int i=1;i<=absexponent;i++){
			result*=base;
		}
		if (exponent<0) {
			result=1.0/result;
		}
		System.out.println(result);
		return result;
	}
	public boolean equal(double num1,double num2){
		if ((num1-num2>-0.0000001)&&(num1-num2<0.0000001)) {
			return true;
		}
		else 
			return false;
	}
	//�����ƴ����2����λ���������
	public double PowerWithUnsignedExponent(double base,int exponent){
		if (exponent==0) {
			return 1;
		}
		if (exponent==1) {
			return base;
		}
		if (base==0&&exponent<0) {
			System.out.println("�������!");
			return 0.0;
		}
		int absexponent=exponent;
		if (exponent<0) {
			absexponent=-exponent;
		}
		double result=PowerWithUnsignedExponent(base, absexponent>>1);
		result*=result;
		if ((exponent&0x1)==1) {
			result*=base;
		}
		if (exponent<0) {
			result=1.0/result;
		}
		return result;
	}
	public static void main(String []args){
		Power problem11=new Power();
		double result=0.0;
		problem11.power(2, -2);
		result=problem11.PowerWithUnsignedExponent(2,-2);
		System.out.println(result);
	}
}
