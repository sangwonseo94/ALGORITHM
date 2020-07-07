package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분해합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(st.nextToken());
		int i =0;
		for( i = 0 ; i < target ; i++) {
			if(target == sol(i)) {
				System.out.println(i);
				break;
			}
		}
		if(i==target) {
			System.out.println(0);
		}
	}

	private static int sol(int i) {
		// i + 각자리의 합을 리턴
		int size = (int) Math.log10(i); // 몇자리인지 알수있따.
		int res = i ; 
		for( ;size >= 0 ; size --) {
			res += (i / Math.pow(10, size));
			i %= Math.pow(10, size);
		}
		return res;
	}
}
