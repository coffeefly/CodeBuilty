package Ω£÷∏offer;

/**
 * øÏÀŸ≈≈–Ú
 * @author caojuan 16-5-8
 *
 */
public class QuickSort {
	public void SortAge(int []ages,int length) throws Exception{
		if (ages==null||length<0) {
			return;
		}
		int oldestage=99;
		int timesOfAge[] = null;
		for(int i=0;i<=oldestage;i++){
			timesOfAge[i]=0;
		}
		for(int i=0;i<length;i++){
			int age=ages[i];
			if (age<0||age>oldestage) {
				throw new Exception("age out of range");
			}
			++timesOfAge[i];
		}
		int index=0;
		for(int i=0;i<=oldestage;i++){
			for(int j=0;j<timesOfAge[i];j++){
				ages[index]=i;
				++index;
			}
		}
	}
}
