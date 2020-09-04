package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hashing {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int mod = 1234567891;
		int r   = 31;
		String str = br.readLine().trim();
		long Multi[] = new long[51];
		Multi[0] =1;
		Multi[1] = 31;
		int answer = 0;
		for(int i = 2 ; i < 51 ; i++) {Multi[i] = r*Multi[i-1]%mod;	}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 51 ; i++) sb.append(Multi[i] + "\n");
		//System.out.println(sb);
		for(int i = 0 ;i < n; i++) {
			char temp = str.charAt(i);
			int res = (int) temp +1 - (int) 'a';
			answer += res*Multi[i] % mod;
		}System.out.println(answer % mod);
	}

}
