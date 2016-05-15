package 剑指offer;

/**
 * 输入数字n，按顺序打印出从1到最大的n位十进制数，比如输入3 则打印出1、2、3一直到最大的3位数即999
 * 
 * @author caojuan 16-5-14
 *
 */
public class problem12 {
	public void Print1ToMaxOfNDigits(int n) {
		if (n < 1) {
			throw new RuntimeException("The input number must be larger than 1.");
		}
		int[] array = new int[n];
		Print1ToMaxOfNDigits(0, array);
	}

	/**
	 * 
	 * @param n
	 *            当前处理的第n个元素，从0开始
	 * @param array
	 *            存放结果的数组
	 */
	public void Print1ToMaxOfNDigits(int n, int[] array) {
		// 递归结束条件
		if (n >= array.length) {
			PrintArray(array);
		} else {
			// 数字的每一位都可能是0-9中的一个数，然后设置下一位
			for (int i = 0; i <= 9; i++) {
				array[n] = i;
				Print1ToMaxOfNDigits(n + 1, array);
			}
		}
	}

	/**
	 * 打印输出结果
	 * 
	 * @param array
	 */
	public void PrintArray(int[] array) {
		// 找第一个非0的元素
		int index = 0;
		while (index < array.length && array[index] == 0) {
			index++;
		}
		// 从第一个非零值开始输出
		for (int i = index; i < array.length; i++) {
			System.out.print(array[i]);
		}
		// 如果数组中有非零元素，需要换行
		if (index < array.length) {
			System.out.println();
		}
	}

	/**
	 * 第二种解法：模拟数字相加
	 * 
	 * @param n
	 */
	public void printOneToNthDigits2(int n) {
		if (n < 1) {
			throw new RuntimeException("The input number must be larger than 1.");
		}
		int[] array = new int[n];
		while (!Increment(array)) {
			PrintArray(array);
		}
	}

	/**
	 * 判断第一个字符是否产生进位
	 * 
	 * @param array
	 * @return
	 */
	public boolean Increment(int[] array) {
		// 判断第[0]位是否有进位
		boolean isOverflow = false;
		// 加一
		int nTakeOver = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			int sum = array[i] + nTakeOver;
			if (i == array.length - 1) {
				sum++;
			}
			if (sum >= 10) {
				if (i == 0) {
					isOverflow = true;
				} else {
					sum -= 10;
					nTakeOver = 1;
					array[i] = sum;
				}
			} else {
				array[i] = sum;
				break;
			}
		}
		return isOverflow;
	}

	public static void main(String[] args) {
		problem12 test1 = new problem12();
		System.out.println("功能测试：");
		test1.Print1ToMaxOfNDigits(2);
		System.out.println("特殊输入测试:");
		test1.Print1ToMaxOfNDigits(-1);
		System.out.println("第二种方法");
		test1.printOneToNthDigits2(2);
	}
}
