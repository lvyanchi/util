package cn.yclv.base.polymorphism;

import cn.yclv.base.model.Person;
import cn.yclv.base.model.Woman;

public class PolyTest {
	
	public static void main(String[] args) {
		Woman[] women = new Woman[3];
//		Person[] persons = new Person[3];
		Person[] persons = women;
//		persons[0] = new Person();
		women[0].setSize(2);
	}
}
