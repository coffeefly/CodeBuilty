package 剑指offer;

/**
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果，
 * 如果是则返回true,否则返回false,假设输入的数组的任意两个数字都互不相同
 * @author caojuan 2016-06-18
 *
 */
public class Problem24 {
	/**
	 * 
	 * @param sequence
	 * @param start 数组的起始位置
	 * @param end 数组的终止位置
	 * @return
	 * @throws Exception 
	 */
	public boolean vertifySequenceOfBST(int sequence[],int start,int end) throws Exception{
		//迭代终止条件
		if (sequence==null||start>=end) {
			return true;
		}
		//找到根节点
		int root=sequence[end];
		//找到第一个大于根节点的数
		int i=start;
		for(;i<end;i++){
			if (sequence[i]>root) {
				break;
			}
		}
		//根据左子节点小于根节点和右子节点大于根节点的原理
		//判断右子数中的元素是否都大于根节点的值
		int j=i;
		for(;j<end;j++){
			//如果右子节点中有数比根节点的值小
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
		//如果左右子树都满足左子树的值小于根节点的值，右子树的值大于根节点的值则返回true
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
