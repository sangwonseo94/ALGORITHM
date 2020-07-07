package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 단어공부 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int max = 0;
		HashMap<Character, Integer> hs = new HashMap<>();
		for(int i = 0 ; i < str.length(); i++) {
			char c = str.charAt(i);
			if(hs.containsKey(c)){
				int t = hs.get(c);
				hs.put(c, t+1);
				max = max > t+1 ? max : t+1;
			} else {
				hs.put(c, 1);
			}
		}
		System.out.println(max);
		
	}
}
