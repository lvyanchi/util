package cn.yclv.base.calc.floa;

public class FloatDemo {
	public static void main(String[] args) {
		floatAdd();
	}
	
	public static void floatAdd(){
		float sum = 0f;
		float a = 0.1f;
		for (int i = 0; i < 100; i++) {
			sum += a;
		}
		System.out.println(sum);
	}
}
