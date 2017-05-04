package cn.yclv.base.exception;

public class WhoCalled {
	static void f(){
		try {
			throw new Exception();
		} catch (Exception e) {
			for (StackTraceElement stackTrace : e.getStackTrace()) {
				System.out.println(stackTrace.getFileName() + "," + stackTrace.getMethodName());
			}
		}
	}
	
	static void g(){
		f();
	}
	
	static void h(){
		g();
	}
	
	public static void main(String[] args) {
		f();
		System.out.println("-----------------------------------------------");
		g();
		System.out.println("-----------------------------------------------");
		h();
	}
}
