package cn.yclv.base.rtti;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ReflectTest {
	private static String usage = "usage:\n" + "ShowMethods qulified.class.name\n"
									+ "To show all methods in class or:\n"
									+ "Show methods qulified.class.name word\n"
									+ "To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.");
	public static void main(String[] args) {
//		args[0] = "000";
//		args[1] = "111";
//		args[2] = "222";
		if(args.length < 1){
			System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor<?>[] constructors = c.getConstructors();
			if(args.length == 1){
				for (Method method : methods) {
					System.out.println(p.matcher(method.toString()).replaceAll(""));
				}
				for (Constructor cost : constructors) {
					System.out.println(p.matcher(cost.toString()).replaceAll(""));
				}
				lines = methods.length + constructors.length;
			}else{
				for (Method m : methods) {
					if(m.toString().indexOf(args[1]) != -1){
						System.out.println(p.matcher(m.toString()).replaceAll(""));
						lines++;
					}
				}
				for (Constructor con : constructors) {
					if(con.toString().indexOf(args[1]) != -1){
						System.out.println(p.matcher(con.toString()).replaceAll(""));
						lines++;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
