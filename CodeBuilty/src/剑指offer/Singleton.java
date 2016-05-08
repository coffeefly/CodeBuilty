package 剑指offer;

public class Singleton {
	/*
	 * java单例模式
	 * 1.线程安全（效率低）
	 * 2.静态内部类
	 */
	//1.线程安全
	private static Singleton instance;
	private Singleton(){}
	public static synchronized Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();
		}
		return instance;
	}
	//2.静态内部类
	private static class SingletonHolder{
		private static final Singleton instance=new Singleton();
	}
	//private Singleton(){}
	public static final Singleton getInstance1(){
		return SingletonHolder.instance;
	}
}




