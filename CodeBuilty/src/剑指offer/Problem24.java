package ��ָoffer;

/**
 * ��Ŀ������һ���������飬�жϸ������ǲ���ĳ�����������ĺ�����������
 * ������򷵻�true,���򷵻�false,�������������������������ֶ�������ͬ
 * @author caojuan 2016-06-18
 *
 */
public class Problem24 {
	/**
	 * 
	 * @param sequence
	 * @param start �������ʼλ��
	 * @param end �������ֹλ��
	 * @return
	 * @throws Exception 
	 */
	public boolean vertifySequenceOfBST(int sequence[],int start,int end) throws Exception{
		//������ֹ����
		if (sequence==null||start>=end) {
			return true;
		}
		//�ҵ����ڵ�
		int root=sequence[end];
		//�ҵ���һ�����ڸ��ڵ����
		int i=start;
		for(;i<end;i++){
			if (sequence[i]>root) {
				break;
			}
		}
		//�������ӽڵ�С�ڸ��ڵ�����ӽڵ���ڸ��ڵ��ԭ��
		//�ж��������е�Ԫ���Ƿ񶼴��ڸ��ڵ��ֵ
		int j=i;
		for(;j<end;j++){
			//������ӽڵ��������ȸ��ڵ��ֵС
			if (sequence[j]<root) {
				return false;
			}
		}
		boolean left=true;
		if (i>start) {
			left=vertifySequenceOfBST(sequence,start,i-1);
		}
		boolean right=true;
		if (i<end) {
			right=vertifySequenceOfBST(sequence,i, end-1);
		}
		//�������������������������ֵС�ڸ��ڵ��ֵ����������ֵ���ڸ��ڵ��ֵ�򷵻�true
		return (left&&right);
	}
	public static void main(String []args) throws Exception{
		Problem24 test=new Problem24();
		int array1[]={5,7,6,9,11,10,8};
		int array2[]={7,4,6,5};
		int array3[]={4, 8, 6, 12, 16, 14, 10};
		int array4[]={4, 6, 7, 5};
		int array5[] = {5,4,3,2,1};
		int array6[]={4, 6, 12, 8, 16, 14, 10};
		System.out.println("array1-->"+test.vertifySequenceOfBST(array1, 0, array1.length-1));
		System.out.println("array2-->"+test.vertifySequenceOfBST(array2, 0, array2.length-1));
		System.out.println("array3-->"+test.vertifySequenceOfBST(array3, 0, array3.length-1));
		System.out.println("array4-->"+test.vertifySequenceOfBST(array4, 0, array4.length-1));
		System.out.println("array5-->"+test.vertifySequenceOfBST(array5, 0, array5.length-1));
		System.out.println("array6-->"+test.vertifySequenceOfBST(array6, 0, array6.length-1));
		System.out.println("array7-->"+test.vertifySequenceOfBST(null, 0, 9));
	}
}
