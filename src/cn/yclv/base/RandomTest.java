package cn.yclv.base;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random random = new Random();
		
		int nextInt = random.nextInt(100000000);
		System.out.println(nextInt);
//		
//		int a = 1;
////		a++;
//		System.out.println("a++ :" + a++);
//		System.out.println("a:" + a);
//		
//		int b = 2;
////		++b;
//		System.out.println(++b);
//		System.out.println(b);
//		
//		int[] arr = new int[random.nextInt(20)];
//		System.out.println("随机创建的数组长度为：" + arr.length);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println("int基本数据类型数组的初始化值为：" + arr[i]);
//		}
//		
//		Integer[] arr2 = new Integer[random.nextInt(20)];
//		System.out.println("随机创建的整形包装器数组长度为：" + arr2.length);
//		for (int i = 0; i < arr2.length; i++) {
//			System.out.println("Integer整形包装器数组的初始化值为：" + arr2[i]);
//		}
//		System.out.println(Arrays.toString(arr2));
		
//		viaParam(1, 2, "yclv");
//		viaParam(new Integer[]{1,3,5});
//		viaParam(new String[]{"aa","bb","cc"});
		
	}
	
	static void viaParam(Object...args){
		for (Object object : args) {
			System.out.println(object);
		}
	}
}
