package 剑指offer;

/**
 * 在二维数组中查找
 * @author caojuan 16-5-3
 *
 */
public class FindInPartiallySortedMatrix {
	public boolean Find(int [][]array,int number){
		boolean findFlag=false;
		if(array!=null){
			int rows=array.length;
			int columns=array[0].length;
			int row=0;
			int column=columns-1;
			while(row<rows&&column>=0){
				if (array[row][column]==number) {
					findFlag=true;
					break;
				}
				else if (array[row][column]>number) {
					column--;
				}
				else {
					row++;
				}
			}
		}
		else{
			System.out.println("输入的数组有误哦！");
			return false;
		}
		if (findFlag) {
			System.out.println("找到啦^_^！");
		}
		else
			System.out.println("没有找到这个数哦^_^换一个试试");
		return findFlag;
	}
	
	public static void main(String args[]){
		int array[][]={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		FindInPartiallySortedMatrix problem3=new FindInPartiallySortedMatrix();
		problem3.Find(null, 15);
	} 
}
