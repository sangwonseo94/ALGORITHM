package CodeForce0906;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int half = k>>1;
			int zcnt = 0;
			int ocnt = 0;
			int qcnt = 0;
			boolean impossible = false;
			String str = br.readLine();
			for(int i = 0 ; i < k-1 ; i++) {
				if(str.charAt(i)=='0') zcnt++;
				if(str.charAt(i)=='1') ocnt++;
				if(str.charAt(i)=='?') qcnt++;
			}
			if( zcnt> half || ocnt > half) {
				impossible = true;
			} else {
				for(int i = k-1 ; i < str.length() ; i++) {
					if( (str.charAt(i-(k-1))=='1' && str.charAt(i+1)=='0')||(str.charAt(i-(k-1))=='0' && str.charAt(i+1)=='1')) {
						impossible = true; break;
					} else if(str.charAt(i-(k-1))=='?' && str.charAt(i+1)=='?') {
						continue;
					} else if((str.charAt(i-(k-1))=='0' && str.charAt(i+1)=='0')||(str.charAt(i-(k-1))=='1' && str.charAt(i+1)=='1')) {
						continue;
					} else if()
					
					
				}
			}
			
			if(impossible) sb.append("NO\n");
			else sb.append("YES\n");
		}
		System.out.println(sb);
	}

}
