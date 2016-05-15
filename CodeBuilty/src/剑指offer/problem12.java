package ��ָoffer;

/**
 * ��������n����˳���ӡ����1������nλʮ����������������3 ���ӡ��1��2��3һֱ������3λ����999
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
	 *            ��ǰ����ĵ�n��Ԫ�أ���0��ʼ
	 * @param array
	 *            ��Ž��������
	 */
	public void Print1ToMaxOfNDigits(int n, int[] array) {
		// �ݹ��������
		if (n >= array.length) {
			PrintArray(array);
		} else {
			// ���ֵ�ÿһλ��������0-9�е�һ������Ȼ��������һλ
			for (int i = 0; i <= 9; i++) {
				array[n] = i;
				Print1ToMaxOfNDigits(n + 1, array);
			}
		}
	}

	/**
	 * ��ӡ������
	 * 
	 * @param array
	 */
	public void PrintArray(int[] array) {
		// �ҵ�һ����0��Ԫ��
		int index = 0;
		while (index < array.length && array[index] == 0) {
			index++;
		}
		// �ӵ�һ������ֵ��ʼ���
		for (int i = index; i < array.length; i++) {
			System.out.print(array[i]);
		}
		// ����������з���Ԫ�أ���Ҫ����
		if (index < array.length) {
			System.out.println();
		}
	}

	/**
	 * �ڶ��ֽⷨ��ģ���������
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
	 * �жϵ�һ���ַ��Ƿ������λ
	 * 
	 * @param array
	 * @return
	 */
	public boolean Increment(int[] array) {
		// �жϵ�[0]λ�Ƿ��н�λ
		boolean isOverflow = false;
		// ��һ
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
		System.out.println("���ܲ��ԣ�");
		test1.Print1ToMaxOfNDigits(2);
		System.out.println("�����������:");
		test1.Print1ToMaxOfNDigits(-1);
		System.out.println("�ڶ��ַ���");
		test1.printOneToNthDigits2(2);
	}
}
