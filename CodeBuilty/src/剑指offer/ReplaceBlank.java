package ½£Ö¸offer;
/**
 * Ìæ»»¿Õ¸ñ
 * @author caojuan 16-5-3
 *
 */
public class ReplaceBlank {
	public String replace(String input){
		if(input==null)
			return null;
		StringBuffer outputBuffer=new StringBuffer();
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i)==' ')
			{
				outputBuffer.append("%");
				outputBuffer.append("2");
				outputBuffer.append("0");
			}
			else {
				outputBuffer.append(String.valueOf(input.charAt(i)));
			}
		}
		System.out.println(outputBuffer);
		return new String(outputBuffer);
}
	
	public static void main(String []args){
		ReplaceBlank replaceBlank=new ReplaceBlank();
		replaceBlank.replace("we are happy.");
	}
}
