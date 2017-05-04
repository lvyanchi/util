package cn.yclv.base;

public class MathTest {
	public static void main(String[] args) {
		System.out.println("Math.E:" + Math.E);
		System.out.println(Math.PI);
		
		int a = (int) (3e4 - 52);
		System.out.println(a);
		
		int m = 1;
		int n = 2;
		
		boolean x = true;
		boolean y = true;
		System.out.println("m=n:" + (m = n));
		if(x = y){
			System.out.println("true=true");
		}
		
		int i = Integer.MAX_VALUE;
		System.out.println("Integer.MAX_VALUE:" + i);
		System.out.println(Integer.BYTES);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.SIZE);
		System.out.println(i*4);
		
	}
}
