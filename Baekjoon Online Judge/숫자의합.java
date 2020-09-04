package solvedClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 숫자의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char ch[] = br.readLine().toCharArray();
		int answer = 0;
		for(int i = 0 ; i < n ; i ++) {
			answer += ch[i] -'0';
		}System.out.println(answer);
	}

}
