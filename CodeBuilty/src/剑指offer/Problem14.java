package ��ָoffer;
/**
 * ��Ŀ������һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿��
 * @author caojuan 16-5-15
 *
 */
public class Problem14 {
	/**
	 * ʵ����������λ�����ֵ�ǰ�벿�֣�����ż��λ�����ֵĺ�벿��
	 * @param array ��ʼ����
	 */
	public void ReorderOddEven(int []array){
		if (array==null||array.length==0) {
			System.out.println("����Ϊ��");
			return;
		}
		int start=0;
		int end=array.length-1;
		while(start<end){
			//�����ƶ�startֱ����ָ��ż��
			while(start<end&&(array[start]&0x1)!=0){
				start++;
			}
			//�����ƶ�endֱ����ָ������
			while(start<end&&(array[end]&0x1)==0){
				end--;
			}
			//����array[start]��array[end]��ֵ
			if (start<end) {
				int temp=array[start];
				array[start]=array[end];
				array[end]=temp;
			}
		}
		printArray(array);
	}
	public void printArray(int []array){
		if (array==null&&array.length==0) {
			System.out.println("����Ϊ��");
		}
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	public static void main(String []args){
		Problem14 test=new Problem14();
		int []array1={1,2,3,4,5,6,7,8,9,10};
		int []array2={1,3,5,7,9,2,4,6,8,10};
		int []array3={2,4,6,8,10,1,3,5,7,9};
		int []array4={};
		int []array5={5};
		//��ʼ����
		test.printArray(array1);
		//������ż���������
		test.ReorderOddEven(array1);
		//������ǰ��ż���ں�
		test.ReorderOddEven(array2);
		//ż����ǰ�������ں�
		test.ReorderOddEven(array3);
		//����Ϊ��
		test.ReorderOddEven(array4);
		//���������ֻ����һ������
		test.ReorderOddEven(array5);
	}
}
