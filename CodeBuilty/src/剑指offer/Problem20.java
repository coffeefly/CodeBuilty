package 剑指offer;

/**
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * @author caojuan
 *
 */
public class Problem20 {
	public void printMatrixClockwisely(int [][]matrix){
		if (matrix==null||matrix.length<=0||matrix[0].length<=0) {
			System.out.println("输入数组为空");
			return;
		}
		int rows=matrix.length;
		int colums=matrix[0].length;
		//表明每一圈左上角坐标
		int start=0;
		while(start*2<rows&&start*2<colums){
			//打印出每一圈的数字
			printMatricInCircle(start,matrix);
			System.out.println("start:"+start);
			start++;
		}
	}
	public void printMatricInCircle(int start,int [][]matrix){
		//找到要打印的圈的右下角的坐标
		int rows=matrix.length;
		int colums=matrix[0].length;
		int endX=colums-1-start;
		int endY=rows-1-start;
		//从左到右打印一行
		for(int i=start;i<=endX;i++){
			 System.out.print(matrix[start][i]+" ");
		}
		//打印从右到下--前提条件至少有两行
		if (endY>start) {
			for(int i=start+1;i<=endY;i++){
				System.out.print(matrix[i][endX]+" ");
			}
		}
		//打印从右到左--前提条件至少有两行两列
		if (endX>start&&endY>start) {
			for(int i=endX-1;i>=start;i--){
				System.out.print(matrix[endY][i]+" ");
			}
		}
		//打印从下到上--前提条件至少有三行两列
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
