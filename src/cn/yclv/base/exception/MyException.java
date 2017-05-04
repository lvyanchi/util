package cn.yclv.base.exception;

import cn.yclv.base.model.exception.SimpleException;

public class MyException{
	public void f() throws SimpleException {
		System.out.println("Throw Exception from f();");
		throw new SimpleException();
	}
	
	public static void main(String[] args) {
		MyException me = new MyException();
		try {
			System.out.println("throw exception之前");
			me.f();
			System.out.println("throw exception之后");
		} catch (SimpleException e) {
			System.err.println("捕捉到了SimpleException!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(" catch Exception");
		} finally {
			System.out.println("finally");
		}
	}
}
