package cn.yclv.crypto.security;

import java.security.Provider;
import java.security.Security;
import java.util.Map;

public class SecurityTest {
	
	public static void main(String[] args) {
		showProviders();
	}
	
	public static void showProviders(){
		for (Provider p : Security.getProviders()) {
			System.out.println(p.getName());
			for (Map.Entry<Object, Object> entry : p.entrySet()) {
				System.out.println(entry.getKey());
			}
			System.out.println("========================================");
		}
	}
}
