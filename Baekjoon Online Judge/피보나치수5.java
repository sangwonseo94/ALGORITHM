package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피보나치수5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		if(n==0) System.out.println("0");
		else if(n==1) System.out.println("1");
		else {
			int a = 0 , b =1 , m =1 , c = 0;
			while(m++<n) {
				c = a + b;
				a = b;
				b = c;

				
			}
			System.out.println(c);
		}
	}

}
