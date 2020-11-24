package solvedClass;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class 검증수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0 ; 
		for(int i = 0 ; i  < 5 ; i++) {
			int t = Integer.parseInt(st.nextToken());
			answer += t*t;
		}
		System.out.println(answer %10);
	}
}
