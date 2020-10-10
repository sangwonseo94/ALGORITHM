package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		st = new StringTokenizer(br.readLine());
		int acgt[] = new int[4];
		for(int i=0;i<4;i++) {acgt[i] = Integer.parseInt(st.nextToken());}
		int myacgt[] = new int[4];
		int answer=0;
		for(int i=0;i<p;i++) {
			if(str.charAt(i)=='A')myacgt[0]++;
			if(str.charAt(i)=='C')myacgt[1]++;
			if(str.charAt(i)=='G')myacgt[2]++;
			if(str.charAt(i)=='T')myacgt[3]++;
		}
		if(acgt[0]<=myacgt[0]&&acgt[1]<=myacgt[1]&&acgt[2]<=myacgt[2]&&acgt[3]<=myacgt[3])answer++;
		
		for(int i=p ;i<n;i++) {
			if(str.charAt(i)=='A')myacgt[0]++;
			if(str.charAt(i)=='C')myacgt[1]++;
			if(str.charAt(i)=='G')myacgt[2]++;
			if(str.charAt(i)=='T')myacgt[3]++;
			
			if(str.charAt(i-p)=='A')myacgt[0]--;
			if(str.charAt(i-p)=='C')myacgt[1]--;
			if(str.charAt(i-p)=='G')myacgt[2]--;
			if(str.charAt(i-p)=='T')myacgt[3]--;
			
			if(acgt[0]<=myacgt[0]&&acgt[1]<=myacgt[1]&&acgt[2]<=myacgt[2]&&acgt[3]<=myacgt[3])answer++;
		}System.out.println(answer);
	}

}
