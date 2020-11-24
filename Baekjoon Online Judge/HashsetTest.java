package 푼문제;

import java.util.HashSet;

public class HashsetTest {

	public static void main(String[] args) {
		HashSet<String> HS = new HashSet<>();
		HS.add("�ϳ�"); HS.add("�ϳ�"); HS.add("�γ�"); HS.add("����"); HS.add("����");
		System.out.println(HS.toArray()[0] + " " + HS.toArray()[1] + " "+ HS.toArray()[2]);
		System.out.println("Hash Set Size : " + HS.size());
	}

}
