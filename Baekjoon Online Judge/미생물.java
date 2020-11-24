package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미생물 {
	static boolean end = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int at = Integer.parseInt(st.nextToken());
		for(int tc = 1 ; tc<= at ; tc++) {
			int s ,t ,a, b;
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			int cnt=0;
			if(b==1) {
				if((t-s) % a ==0) cnt = (t-s)/a;
				else cnt = -1;
			}
			else {
				while(s<t) { // s를 늘려준다.
					if((t-s)%b ==0) {
						if((t-s)/b < s) {s +=a; cnt++;}
						else {s *=b; cnt++;}
					}
					else {cnt++;s +=a;}
					
				}
				if(s > t) {cnt = -1;}
			}
			System.out.println("#"+tc+" "+cnt);
		}	
	}

}
