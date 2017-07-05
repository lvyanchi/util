package cn.yclv.base;

public class MathTest {
	public static void main(String[] args) {
		testFloor();
	}

	private static void testBase() {
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
	
	
	
	public static void testFloor(){
		Double a1 = 344.7d;
		Double a2 = 344.78d;
		Double a3 = 344.789d;
		
		Long b1 = 34470l;
		Long b2 = 34471l;
		Long b3 = 34472l;
		Integer c = 5669;
		
		double a1Floor = Math.floor(a1);
		double a2Floor = Math.floor(a2);
		double a3Floor = Math.floor(a3);
		System.out.println(a1Floor);
		System.out.println(a2Floor);
		System.out.println(a3Floor);
		
		double b1Floor = Math.floor(b1);
		System.out.println(b1Floor);
	}
	
	
	
}
