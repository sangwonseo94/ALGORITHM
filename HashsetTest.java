package practice;

import java.util.HashSet;

public class HashsetTest {

	public static void main(String[] args) {
		HashSet<String> HS = new HashSet<>();
		HS.add("하나"); HS.add("하나"); HS.add("두나"); HS.add("세나"); HS.add("세나");
		System.out.println(HS.toArray()[0] + " " + HS.toArray()[1] + " "+ HS.toArray()[2]);
		System.out.println("Hash Set Size : " + HS.size());
	}

}
