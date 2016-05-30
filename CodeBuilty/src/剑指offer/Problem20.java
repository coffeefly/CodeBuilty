package ��ָoffer;

/**
 * ��Ŀ������һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ������
 * @author caojuan
 *
 */
public class Problem20 {
	public void printMatrixClockwisely(int [][]matrix){
		if (matrix==null||matrix.length<=0||matrix[0].length<=0) {
			System.out.println("��������Ϊ��");
			return;
		}
		int rows=matrix.length;
		int colums=matrix[0].length;
		//����ÿһȦ���Ͻ�����
		int start=0;
		while(start*2<rows&&start*2<colums){
			//��ӡ��ÿһȦ������
			printMatricInCircle(start,matrix);
			System.out.println("start:"+start);
			start++;
		}
	}
	public void printMatricInCircle(int start,int [][]matrix){
		//�ҵ�Ҫ��ӡ��Ȧ�����½ǵ�����
		int rows=matrix.length;
		int colums=matrix[0].length;
		int endX=colums-1-start;
		int endY=rows-1-start;
		//�����Ҵ�ӡһ��
		for(int i=start;i<=endX;i++){
			 System.out.print(matrix[start][i]+" ");
		}
		//��ӡ���ҵ���--ǰ����������������
		if (endY>start) {
			for(int i=start+1;i<=endY;i++){
				System.out.print(matrix[i][endX]+" ");
			}
		}
		//��ӡ���ҵ���--ǰ��������������������
		if (endX>start&&endY>start) {
			for(int i=endX-1;i>=start;i--){
				System.out.print(matrix[endY][i]+" ");
			}
		}
		//��ӡ���µ���--ǰ��������������������
		if (endY-1>start&&endX>start) {
			for(int i=endY-1;i>start;i--){
				System.out.print(matrix[i][start]+" ");
			}
		}
	}
	public static void main(String []args){
		int [][]matrix={{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}};
		int [][]test2={{1,2,3,4},
				{12,13,14,5},
				{11,16,15,6},
				{10,9,8,7}};
		int [][]test3={{1,2,3,4}};
		int [][]test4={{9}};
		int [][]tets5={{5},
				{4},
				{3},
				{2}};
		int [][]test6={};
		Problem20 test=new Problem20();
		test.printMatrixClockwisely(matrix);
		test.printMatrixClockwisely(test2);
		test.printMatrixClockwisely(test3);
		test.printMatrixClockwisely(test4);
		test.printMatrixClockwisely(tets5);
		test.printMatrixClockwisely(test6);
	}
}
