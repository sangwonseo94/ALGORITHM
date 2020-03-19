package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기 {
	static long seg[] ,num[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		num = new long[n];
		seg = new long[4*n];
		for(int index = 0 ; index < n ; index++) {num[index] = Integer.parseInt(br.readLine());}
		seginit(1,0,n-1);
		for(int index = 0 ; index < m + k ; index++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a ==1) {
				// update
				int i = b-1;
				long diff = c - num[i];
				num[i] = c;
				update(1,0,n-1,i,diff);
			}
			else {
				// compute sum
				if(b > c) {
					int temp = b;
					b = c;
					c= temp;
				}
				System.out.println(sum(1,0,n-1,b-1,c-1));
			}
			
		}
	}
	private static void update(int n, int s, int e, int i, long diff) {
		if(i < s || i > e) return;
		seg[n] +=diff;
		if(s!=e) {
			update(n*2 , s , (s+e)/2 , i , diff);
			update(n*2+1 , (s+e)/2+1,e , i , diff);
		}
	}
	private static long sum(int n, int s, int e, int l, int r) {
		if( l > e || r < s) return 0;
		else if(l <= s && e <= r) return seg[n];
		else {
			return sum(2*n , s , (s+e)/2 , l , r) +sum(2*n+1 , (s+e)/2+1,e,l,r);
		}
	}
	public static long seginit(int n , int s , int e) {
		if(s == e) {
			// leaf node
			return seg[n] = (long )num[s];
		}
		else {
			return seg[n] = seginit(n*2 , s , (s+e)/2) + seginit(n*2+1, (s+e)/2+1, e);
		}
	}

}
