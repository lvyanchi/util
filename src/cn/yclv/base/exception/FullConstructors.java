package cn.yclv.base.exception;

import cn.yclv.base.model.exception.ExtendsException;

public class FullConstructors {
	public static void f() throws ExtendsException{
		System.out.println("throw ExtendsException from f()");
		throw new ExtendsException();
	}
	
	public static void g() throws ExtendsException{
		System.out.println("throw ExtendsException from f() have msg");
		throw new ExtendsException("error");
	}
	
	public static void main(String[] args) {
		try {
			f();
		} catch (ExtendsException e) {
			System.out.println("调用f方法出现异常");
			System.out.println("调用f方法出现异常的错误信息打印------------------------------------------------");
			e.printStackTrace();
			System.out.println("调用f方法出现异常的错误信息打印结束------------------------------------------------");
		}
		
		try {
			g();
		} catch (ExtendsException e) {
			e.printStackTrace();
		}
	}
}