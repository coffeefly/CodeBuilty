package 剑指offer;

/**
 * 求数值的整数次方
 * @author caojuan 16-5-8
 *
 */
public class Power {
	public double power(double base,int exponent){
		if (equal(base,0.0)&&exponent<0) {
			System.out.println("输入有误!");
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
	//用右移代替除2，用位与代替求余
	public double PowerWithUnsignedExponent(double base,int exponent){
		if (exponent==0) {
			return 1;
		}
		if (exponent==1) {
			return base;
		}
		if (base==0&&exponent<0) {
			System.out.println("输入错误!");
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
