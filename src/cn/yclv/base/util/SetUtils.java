package cn.yclv.base.util;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {
	public static <T> Set<T> union(Set<T> a, Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	
	public static <T> Set<T> intersection(Set<T> a, Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	
	public static <T> Set<T> difference(Set<T> superSet, Set<T> subSet){
		Set<T> result = new HashSet<T>(superSet);
		result.removeAll(subSet);
		return result;
	}
	
	public static <T> Set<T> complement(Set<T> a, Set<T> b){
		return difference(union(a, b), intersection(a, b));
	}
	
	public static void main(String[] args) {
		Set<Integer> one = new HashSet<Integer>();
		one.add(1);
		one.add(2);
		one.add(3);
		
		Set<Integer> two = new HashSet<Integer>();
		two.add(1);
		two.add(2);
		two.add(4);
		two.add(6);
		two.add(8);
		
		Set<Integer> union = SetUtils.union(one, two);
		Set<Integer> intersection = SetUtils.intersection(one, two);
		System.out.println("union:" + union);
		System.out.println("intersection:" + intersection);
		System.out.println("difference:" + SetUtils.difference(one, two));
	}
}
