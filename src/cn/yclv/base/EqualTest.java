package cn.yclv.base;

import cn.yclv.base.model.Man;
import cn.yclv.base.model.User;

public class EqualTest {
	public static void main(String[] args) {
		Integer a = new Integer(11);
		Integer b = new Integer(11);
		
		int m = 11;
		int n = 11;
		
		float f1 = 1.1f;
		float f2 = 1.1f;
		
		double d1 = 2.1d;
		double d2 = 2.1d;
		
		System.out.println("两个对象内容相同，用==的结果为：" + (a == b));//如果是对象的话，则==比较的是对象的引用。对象内容相同，但是对象引用不同，所以结果为false
		System.out.println("两个对象内容相同，用equals的结果为：" + (a.equals(b)));//如果是对象的话，则equals比较的是对象的内容。equals方法不适用基本数据类型
		System.out.println(m == n);
		System.out.println(f1 == f2);
		System.out.println(d1 == d2);
		
		User user1 = new User();
		user1.setId(1);
		user1.setName("aa");
		User user2 = new User();
		user2.setId(1);
		user2.setName("aa");
		
		System.out.println("user1.equals(user2):" + user1.equals(user2));
		System.out.println("user1 == user2:" + (user1 == user2));
		
		Man man1 = new Man();
		Man man2 = new Man();
		System.out.println(man1.equals(man2));
		
		
		
	}
}
