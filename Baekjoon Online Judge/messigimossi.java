package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class messigimossi {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken())-1;
		String m = "Messi Gimossi";
		String wrong = "Messi Messi Gimossi";
		long fibo[] = new long[100];
		int limit = (int) (Math.pow(2, 30)-1);
		fibo[1] = 8;
		fibo[2] = 13;
		for(int i = 3 ; i <= 40 ; i++) {
			fibo[i] = fibo[i-1]+fibo[i-2] +1; 
			if(fibo[i] >= limit) break;
		}
		for(int i = 40 ; i >=1 ; i--) {
			if(n >= fibo[i]) n -=(fibo[i]+1);
		}
		if(n < 0  || n==4) System.out.println(wrong);
		else System.out.println(m.charAt(n-1));
	
	}

}
