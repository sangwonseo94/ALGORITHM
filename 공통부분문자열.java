package algorithm;

import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 공통부분문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strA = "0"+br.readLine();
		String strB = "0"+br.readLine();
		int answer = 0;
		int map[][] = new int[strA.length()][strB.length()];
		for(int i = 1 ; i < strA.length() ; i++) {
			for(int j = 1 ; j < strB.length() ; j++) {
				if(strA.charAt(i) == strB.charAt(j)) {
					map[i][j] = map[i-1][j-1]+1;
					answer = answer > map[i][j] ? answer : map[i][j];
				}
			}
		}System.out.println(answer);
	}
}
