package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 중앙값구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		ArrayList<Integer> al = new ArrayList<>();
		for(int tc=1; tc<=T ;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			System.out.println((int)Math.ceil(((double)n)/2));
			for(int i = 1 ; i <= n ; i ++) {
				al.add(Integer.parseInt(st.nextToken()));
				if(i%2 == 1) {
					Collections.sort(al);
					System.out.print(al.get(al.size()/2)+" ");
					if(i%20 == 0) System.out.println();
				}
				if(i % 10 == 0) st = new StringTokenizer(br.readLine());
			}
			System.out.println();
			al.clear();
		}
	}

}
