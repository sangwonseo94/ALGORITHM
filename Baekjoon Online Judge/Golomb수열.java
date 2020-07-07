package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Golomb수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> hs = new HashMap<>();
		hs.put(1, 1);
		int sum = 1;
		for(int i = 1 ; i < n ; i ++) {
			hs.put(i+1 , 1+ hs.get( i +1 - hs.get(hs.get(i))));
			sum += hs.get(i+1);
			if(sum >=n) {
				System.out.println(i+1);
				break;
			};
		}
		if(n==1) System.out.println(1);
	}
}
