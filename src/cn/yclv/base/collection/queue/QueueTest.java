package cn.yclv.base.collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> qStr = new PriorityQueue<String>();
		qStr.add("aa");
		qStr.add("bb");
		qStr.add("cc");
		System.out.println(qStr);
		boolean offer = qStr.offer("22a");
		System.out.println(offer);
//		String pollStr = qStr.poll();
//		String peekStr = qStr.peek();
//		System.out.println("pollStr:" + pollStr);
//		System.out.println("peekStr:" + peekStr);
//		System.out.println(qStr);
//		String poll = qStr.poll();
		System.out.println(qStr);
		String element = qStr.element();
		System.out.println(element);
	}
}
