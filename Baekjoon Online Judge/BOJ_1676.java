package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1676 {
    public static int a,b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			divide(i);
		}
		System.out.println(a>b?b:a);
	}
	private static void divide(int i) {
		if(i%2==0&&i%5==0) {
			a++;b++;
			divide(i/10);
		} else if(i%5==0) {
			b++;
			divide(i/5);
		} else if(i%2==0) {
			a++;
			divide(i/2);
		} 
		return;
		
	}

}
