package cn.yclv.base.annotation;

import java.util.List;

public class PasswordUtils {
	@UseCase(id = 47, description = "password not less than 8 letters")
	public static boolean validatePwd(String pwd){
		return (pwd.matches("\\w*\\d\\w*"));
	}
	
	@UseCase(id = 48)
	public static String encriptyPwd(String pwd){
		return new StringBuilder(pwd).reverse().toString();
	}
	
	@UseCase(id = 49, description = "new password can't equal to ")
	public static boolean checkForNewPwd(List<String> prePwds, String pwd){
		return !prePwds.contains(pwd);
	}
	
}
