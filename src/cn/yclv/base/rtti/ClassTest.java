package cn.yclv.base.rtti;

interface HasBatteried{}
interface WaterProof{}
interface Shoots{}

class Toy{
	Toy(){}
	Toy(int i){}
}

class FancyToy extends Toy implements HasBatteried, WaterProof, Shoots{
	public FancyToy() {
		super(1);
	}
}

public class ClassTest {
	static void printInfo(Class c){
		System.out.println("Class name:" + c.getName() + "; is Interface? " + c.isInterface());
		System.out.println("Simple name:" + c.getSimpleName());
		System.out.println("CanonicalName:" + c.getCanonicalName());
	}
	
	public static void main(String[] args) {
		
		FancyToy fancyToy = new FancyToy();
		if(fancyToy instanceof Toy){
			System.out.println("fancyToy对象是Toy的一种");
		}
		
		Class c = null;
		try {
			c = Class.forName("cn.yclv.base.rtti.FancyToya");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到FancyToy这个类");
			e.printStackTrace();
			System.exit(1);
		}
		printInfo(c);
		System.out.println("-----------------------------------------------------");
		for (Class clazz : c.getInterfaces()) {
			printInfo(clazz);
		}
		System.out.println("-----------------------------------------------------");
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			System.out.println("无法进行实例化!");
			e.printStackTrace();
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("非法访问!");
			e.printStackTrace();
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
}
