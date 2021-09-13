package 알고리즘공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열1120 {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a , b ;
		a = st.nextToken();
		b = st.nextToken();
		int min = 51;
		
		for(int i=0;i<=b.length()-a.length();i++) {
			int cnt =0;
			for(int j=0;j<a.length();j++) {
				if(a.charAt(j) != b.charAt(j+i)) {
					cnt++;
				}
			}
			min = min > cnt ? cnt : min;
		}
		System.out.println(min);
	}
}
