package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 개똥벌레 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		// 각 높이로 진행했을때 만나는 개수
		int dp1[] = new int[h+1];
		int dp2[] = new int[h+1];
		int up[] = new int[n/2];
		int down[] = new int[n/2];
		
		for(int i=0;i<n/2;i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			down[i] = now;
			st = new StringTokenizer(br.readLine());
			now = Integer.parseInt(st.nextToken());
			up[i] = now;
		}
		Arrays.sort(up);
		Arrays.sort(down);
		// dp 계산
		int ccnt =0;
		int nnow =up[n/2-1];
		for(int s=n/2-1;s>=0;s--) {
			if ( up[s] == nnow) {
				ccnt++;
			} else {
				for(int ss = up[s]+1 ; ss <= nnow ;ss++) dp1[ss] = ccnt;
				ccnt=1;
				nnow=up[s];
			}
		}
		int answer = 987654321;
		int cnt =0;
		for(int i=1;i<=h;i++) {
			// 내가 1 이면 석유석입장에선 맨위
			int hh = i;
			int rh = (h+1)-i;
			int res = dp1[hh] + dp2[rh];
			if(answer>res) {
				answer = res;
				cnt =1;
			} else if(answer==res) {
				cnt++;
			}
		}
		System.out.println(answer);
		System.out.println(cnt);
	}

}
