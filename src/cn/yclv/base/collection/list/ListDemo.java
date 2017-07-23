package cn.yclv.base.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		retainTest();
	}
	
	public static void listTest(){
		List<String> aList = new ArrayList<String>();
		aList.add("b");
		aList.add("a");
		aList.add("c");
		System.out.println(aList.toString());
		String string = aList.get(0);
		System.out.println(string);
	}
	
	
	public static void listTest2(){
		List<String> aList = new ArrayList<String>(5);
		aList.add("1");
		System.out.println(aList.toString());
	}
	
	
	public static void listTrimToSize(){
		List<String> aList = new ArrayList<String>(5);
		
		aList.add("1");
	}
	
	public static void listIterator(){
		List<String> aList = new ArrayList<String>(5);
		aList.add("b");
		aList.add("a");
		aList.add("c");
		aList.add("1");
		Iterator<String> iterator = aList.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			iterator.remove();
//			System.out.println("-------" + aList.size());
		}
	}
	
	
	public static void retainTest(){
		List<String> aList = new ArrayList<String>();
		aList.add("b");
		aList.add("a");
		aList.add("c");
		aList.add("1");
		List<String> bList = new ArrayList<String>();
		bList.add("b");
		bList.add("1");
		bList.add("2");
		bList.add("3");
		boolean retainAll = aList.retainAll(bList);
		System.out.println(retainAll);
		System.out.println(aList.toString());
		System.out.println(bList.toString());
	}
}
