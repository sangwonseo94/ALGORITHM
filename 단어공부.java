package solvedClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 단어공부 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int index[] = new int['z'-'a'+1];
		for(int i = 0 ; i < str.length() ; i ++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <='Z' ) {
				index[str.charAt(i)-'A']++;
			} else {
				index[str.charAt(i)-'a']++;
			}
		}
		int max = 0;
		char answer =0;
		boolean check = false;
		for(int i = 0 ; i < index.length ; i++) {
			if(max < index[i]) {
				max = index[i];
				answer = (char) (i + 'A');
				check = false;
				continue;
			} else if(max == index[i]) {
				check = true;
			}
		}
		if(check) System.out.println("?");
		else {System.out.println(answer);}
		
	}
}
