package cn.yclv.base.collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	
	public static void main(String[] args) {
		getMaintainsByOrder();
	}

	private static String getMaintainsByOrder() {
		Set<String> daBaoYangSet = new HashSet<String>();
		daBaoYangSet.add("机油");
		daBaoYangSet.add("机滤");
		daBaoYangSet.add("空气滤");
		daBaoYangSet.add("空调滤");
		Set<String> xiaoBaoYangSet = new HashSet<String>();
		xiaoBaoYangSet.add("机油");
		xiaoBaoYangSet.add("机滤");
		Set<String> partTypeSet = new HashSet<String>();
		partTypeSet.add("机油");
		partTypeSet.add("机滤");
		partTypeSet.add("空气滤");
		partTypeSet.add("空调滤");
//		partTypeSet.addAll(daBaoYangSet);
		partTypeSet.add("前刹车片");
		partTypeSet.add("空调管路清洗");
		
		if (partTypeSet.contains("机油") && partTypeSet.contains("机滤")){
			if (partTypeSet.contains("空气滤") && partTypeSet.contains("空调滤")) {
				partTypeSet.removeAll(daBaoYangSet);
				partTypeSet.add("大保养");
			}else{
				partTypeSet.removeAll(xiaoBaoYangSet);
				partTypeSet.add("小保养");
			}
		}
		System.out.println(partTypeSet.toString());
		return null;
	}
}
