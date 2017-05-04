package cn.yclv.base;

import java.util.Random;

import org.apache.ibatis.io.ResolverUtil.Test;

public class BitOperator {
	public static void main(String[] args) {
//		int i = 16;
//		System.out.println(Integer.toBinaryString(i) + ", length:" + Integer.toBinaryString(i).length());
//		i <<= 4;
//		System.out.println(Integer.toBinaryString(i) + ", length:" + Integer.toBinaryString(i).length());
//		System.out.println("i移位之后的结果为：" + i);
//		
//		System.out.println("=======================================================");
//		Random random = new Random();
//		for (int j = 0; j < 1000; j++) {
//			System.out.println(random.nextInt(100));
//		}
//		int a = random.nextInt();
//		int b = random.nextInt();
//		System.out.println(a);
//		System.out.println(b);
		
//		test(false, false);
		
		Season spring = Season.SPRING;
		for (Season season : Season.values()) {
			System.out.println(season + "," + season.ordinal());
		}
		System.out.println(Season.valueOf("SUMMER"));
	}

	
	static void test(boolean x, boolean y){
		System.out.println("按位与x & y:" + (x & y));
		System.out.println("按位或x | y:" + (x | y));
		System.out.println("异或x ^ y:" + (x ^ y));
		System.out.println("非~y:" + !y);
	}
}
