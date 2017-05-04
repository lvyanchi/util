package cn.yclv.base.exception;

public class RunTimeExceptionDemo {
	static void f(){
		throw new RuntimeException();
	}
	
	static void g(){
		f();
	}
	
	public static void main(String[] args) {
		f();
	}
}
