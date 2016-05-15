package 剑指offer;
/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 * @author caojuan 16-5-15
 *
 */
public class Problem14 {
	/**
	 * 实现所有奇数位于数字的前半部分，所有偶数位于数字的后半部分
	 * @param array 初始数组
	 */
	public void ReorderOddEven(int []array){
		if (array==null||array.length==0) {
			System.out.println("数组为空");
			return;
		}
		int start=0;
		int end=array.length-1;
		while(start<end){
			//向右移动start直到它指向偶数
			while(start<end&&(array[start]&0x1)!=0){
				start++;
			}
			//向左移动end直到它指向奇数
			while(start<end&&(array[end]&0x1)==0){
				end--;
			}
			//交换array[start]和array[end]的值
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
			System.out.println("数组为空");
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
		//初始数组
		test.printArray(array1);
		//奇数和偶数交替出现
		test.ReorderOddEven(array1);
		//奇数在前，偶数在后
		test.ReorderOddEven(array2);
		//偶数在前，奇数在后
		test.ReorderOddEven(array3);
		//数组为空
		test.ReorderOddEven(array4);
		//输入的数组只包括一个数字
		test.ReorderOddEven(array5);
	}
}
