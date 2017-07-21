package cn.yclv.base.annotation;

public class MainTest {
	public static void main(String[] args) {
		String validatePwd = PasswordUtils.encriptyPwd("123");
		System.out.println(validatePwd);
		
	}
}
