package cn.yclv.base.rtti;

public class BaseClassTest {
	public static void main(String[] args) {
		Class<Boolean> booleanClass = Boolean.TYPE;
		Class<Integer> intClass = Integer.TYPE;
		System.out.println(booleanClass.getName());
		System.out.println(intClass.getName());
	}
}
