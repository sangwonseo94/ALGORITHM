package 푼문제;

import java.util.HashMap;

public class Hashmaptest {
	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("�����", "���ִ�");
		hm.put("�����", "�߻����");
		hm.put("����", "�׳ɱ׷���");
		System.out.println(hm.get("�����"));
		System.out.println(hm.get("����"));
	}
}
