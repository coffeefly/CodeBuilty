package 剑指offer;
/**
 * 旋转数组求最小值
 * @author caojuan 16-5-8
 *
 */
public class Min {
	public int min(int []num){
		if (num==null) {
			System.out.println("数组为空！");
			return -1;
		}
		int start=0;
		int end=num.length-1;
		int mid=start;
		while(num[start]>=num[end]){
			if (end-start==1) {
				mid=end;
				break;
			}
			mid=(start+end)/2;
			//顺序查找
			if (num[start]==num[end]&&num[mid]==num[start]) {
				return MinInOrder(num, start, end);
			}
			if (num[mid]>=num[start]) {
				start=mid;
			}
			else if (num[mid]<=num[end]) {
				end=mid;
			}
		}
		System.out.println(num[mid]);
		return num[mid];
	}
	public int MinInOrder(int num[],int start,int end){
		int result=num[start];
		for(int i=start+1;i<end;i++){
			if (result>num[i]) {
				result=num[i];
			}
		}
		System.out.println("顺序查找："+result);
		return result;
	}
	public static void main(String []args){
		Min min=new Min();
		int num1[]={3,4,5,1,2};
		int num2[]={1,1,1,0,1};
		int num3[] = null;
		int num4[]={1,2,3,4,0};
		min.min(num4);
	}
}


