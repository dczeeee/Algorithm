package 单例设计模式;
/*
 * 1、饿汉式：在程序启动或单件模式类被加载的时候，单件模式实例就已经被创建。
 * 2、懒汉式：当程序第一次访问单件模式实例时才进行创建。
 */

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