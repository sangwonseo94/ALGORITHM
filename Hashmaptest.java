package practice;

import java.util.HashMap;

public class Hashmaptest {
	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("서상원", "멋있다");
		hm.put("서상원", "잘생겼다");
		hm.put("원상서", "그냥그렇다");
		System.out.println(hm.get("서상원"));
		System.out.println(hm.get("원상서"));
	}
}
