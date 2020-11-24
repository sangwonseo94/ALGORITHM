package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 1000001;
		int N = Integer.parseInt(st.nextToken());
		int person[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int index = 0 ; index < N ;index++) person[index] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int Memo[] = new int[max];
		long answer= 0;
		int temp= 0 , temp2=1; 
		for(int index = 0 ; index < N ; index++) {
			if(Memo[person[index]]!=0) {
				answer +=Memo[person[index]];
				continue;
			}
			temp = person[index];
			temp2=1;
			if(temp-B > 0) {
				temp2 +=((temp-B)/C);
				if((temp-B)%C != 0 ) temp2++;
			}
			Memo[temp] = temp2; 
			answer += temp2;
		}
		
		System.out.println(answer);
		
	}
}
