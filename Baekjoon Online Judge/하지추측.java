package 풀문제;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 하지추측 {

	public static void main(String[] args)throws Exception {
		Scanner sc= new Scanner(System.in);
		int t= sc.nextInt();
		StringBuilder sb= new StringBuilder();
		HashSet<Long> s = new HashSet<>();
		for(int tc=1;tc<=t;tc++) {
			long n = sc.nextLong();
			String answer = "YES";
			if((n&1)==1) {answer="NO";} 
			else {while(n>1) {
				//System.out.println(n);
				if((n&1)==1) {answer="NO";break;} 
				n>>=1;
			}
			}
			sb.append("#"+tc+" "+answer+"\n");
			s.clear();
		}
		System.out.print(sb);
	}

}
