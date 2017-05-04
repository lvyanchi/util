package cn.yclv.base.exception;

import cn.yclv.base.model.exception.LoggingException;

public class LoggingExceptions {
	public static void main(String[] args) {
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("捕获到了异常：" + e);
		}
		
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("捕获到了异常：" + e);
		}
		
	}
}
