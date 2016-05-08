package ��ָoffer;

public class Singleton {
	/*
	 * java����ģʽ
	 * 1.�̰߳�ȫ��Ч�ʵͣ�
	 * 2.��̬�ڲ���
	 */
	//1.�̰߳�ȫ
	private static Singleton instance;
	private Singleton(){}
	public static synchronized Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();
		}
		return instance;
	}
	//2.��̬�ڲ���
	private static class SingletonHolder{
		private static final Singleton instance=new Singleton();
	}
	//private Singleton(){}
	public static final Singleton getInstance1(){
		return SingletonHolder.instance;
	}
}




