package 单例设计模式;

//饿汉式
public class Singleton {
	private Singleton() {}
	private static Singleton instance = new Singleton();
	public static Singleton getInstance() {
		return instance;
	}
}

//懒汉式
class Singleton1{
	private static Singleton1 instance = null;
	private Singleton1() {}
	public static synchronized Singleton1 getInstance() {
		if(instance == null)
			instance = new Singleton1();
		return instance;
	}
}