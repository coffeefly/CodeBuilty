package ��ָoffer;
/**
 * ��ת��������Сֵ
 * @author caojuan 16-5-8
 *
 */
public class Min {
	public int min(int []num){
		if (num==null) {
			System.out.println("����Ϊ�գ�");
		}
		int start=0;
		int end=num.length-1;
		int mid=num[start];
		while(num[start]>=num[end]){
			if (end-start==1) {
				mid=end;
				break;
			}
			mid=(start+end)/2;
			if (num[mid]>num[start]) {
				
			}
		}
		return num[mid];
	}
}


