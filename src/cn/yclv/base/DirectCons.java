package cn.yclv.base;

public class DirectCons {
	public static void main(String[] args) {
		int i = 15;
		int i1 = 0x2f;
		System.out.println("i1:" + Integer.toBinaryString(i1));
		
		int i2 = 012;
		String binaryString = Integer.toBinaryString(i);
		String binaryString2 = Integer.toBinaryString(i2);
		System.out.println("i2的二进制结果为:" + Integer.toBinaryString(i2));
		System.out.println("i2有16进制结果为:" + Integer.toHexString(i2));
		System.out.println("i2有8进制结果为:" + Integer.toOctalString(i2));
		
		System.out.println("i的二进制结果为:" + Integer.toBinaryString(i));
		System.out.println("i的16进制结果为:" + Integer.toHexString(i));
		System.out.println("i的8进制结果为:" + Integer.toOctalString(i));
		System.out.println(Integer.min(i, i2));
		
		System.out.println("===================================================");
		
		System.out.println(binaryString);
		System.out.println(binaryString2);
//		System.out.println(binaryString2 & binaryString);
		
	}
}
