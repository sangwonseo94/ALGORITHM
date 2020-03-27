package 푼문제;

import java.util.Scanner;

public class 배열의분할 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc<= T ; tc++) {
			int n = sc.nextInt();
			int ans =1;
			int now = 0;
			int pre1 = 0 ;
			int pre2 = 0 ;
			for(int i = 0; i < n ; i ++) {
				now = sc.nextInt();
				if(pre2 ==0) {
					pre2 = now;
				}
				else if(pre2 != 0 && pre1 == 0) {
					pre1 = now;
				}
				else if(pre1 == now) continue;
				else if( (pre2 < pre1 && pre1 > now) || (pre2 > pre1 && pre1 < now)) {
					ans++;
					pre2 = now;
					pre1 = 0;
				}
				else {
					
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}

}
