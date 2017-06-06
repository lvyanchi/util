package cn.yclv.base.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

import cn.yclv.base.model.Person;

public class LambdaTest {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			intList.add(new Random().nextInt(50));
		}

		Integer[] intArr = intList.toArray(new Integer[intList.size()]);
		for (int i = 0; i < intArr.length; i++) {
//			System.out.println("i:" + intArr[i]);
		}

		String[] players = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner" };

		List<Person> javaProgrammers = new ArrayList<Person>() {
			{
				add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
				add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
				add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
				add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
				add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
				add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
				add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
				add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
				add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
				add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
			}
		};
		
		List<Person> phpProgrammers = new ArrayList<Person>() {  
			{  
				add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));  
				add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));  
				add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));  
				add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));  
				add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));  
				add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));  
				add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));  
				add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));  
				add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));  
				add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));  
			}  
		};  
//		lambdaSort(players);
		
//		lambdaStream(javaProgrammers, phpProgrammers);
		
//		lambdaFilter(javaProgrammers);
		
		lambdaLimit(javaProgrammers);
	}

	static void lambdaForEach(List<Integer> list) {
		list.forEach((intOne) -> System.out.println(intOne));
		System.out.println("----------------------------------------");
		list.forEach(System.out::println);
	}

	static void lambdaSort(String[] arr) {
		// Arrays.sort(arr, new Comparator<String>() {
		// @Override
		// public int compare(String o1, String o2) {
		// return o1.compareTo(o2);
		// }
		// });
		// System.out.println("----------------------------------------");
		// for (Object object : arr) {
		// System.out.println(object);
		// }
		// System.out.println("----------------------------------------");

		// lambda形式
		Arrays.sort(arr, (String s1, String s2) -> (s1.compareTo(s2)));
		for (String string : arr) {
			System.out.println(string);
		}

	}

	static void lambdaStream(List<Person> aList, List<Person> bList) {
//		aList.forEach(jProgrammer -> System.out.printf("%s, %s", jProgrammer.getFirstName(), jProgrammer.getLastName()));
		System.out.println("=========================");
//		bList.forEach(pProgrammer -> System.out.printf("%s, %s", pProgrammer.getFirstName(), pProgrammer.getLastName()));
		System.out.println("------------------");
		bList.stream().filter((p) -> (p.getSalary() > 1200)).forEach(p -> System.out.printf("%s, %s", p.getFirstName(), p.getLastName()));
	}
	
	static void lambdaFilter(List<Person> personList){
		Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1200);
		
		Stream<Person> stream = personList.stream().filter(salaryFilter);
		
		stream.forEach(p -> System.out.println(p.getFirstName()));
	}
	static void lambdaLimit(List<Person> personList){
		personList.stream().limit(3).forEach(p -> System.out.println(p.getFirstName()));
	}

}
