package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 스타일리쉬 {
	static int [][]m; 
	static int dap[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		int t = Integer.parseInt(st.nextToken());
		for(int tc=1 ; tc<= t ; tc++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			m = new int[p][4];
			for (int i = 0; i < p; i++) {
				String line = br.readLine();
				int index = 0 ; 
				while(line.charAt(index) == '.') {
					index++;
				}
				m[i][0] = index;
				
				if(i > 0) {
					m[i][1] = m[i-1][1];
					m[i][2] = m[i-1][2];
					m[i][3] = m[i-1][3];
				}
				for (int j = index	; j < line.length(); j++) {
					
					switch (line.charAt(j)) {
					case '(': m [i][1]++; break;
					case ')': m [i][1]--; break;
					case '{': m [i][2]++; break;
					case '}': m [i][2]--; break;
					case '[': m [i][3]++; break;
					case ']': m [i][3]--; break;
					}
				}
			}
			
			//내 
			dap = new int[q][4];
			for (int i = 0; i < q; i++) {
				String line = br.readLine();
				int index = 0 ; 
				
				if(i > 0) {
					dap[i][1] = dap[i-1][1];
					dap[i][2] = dap[i-1][2];
					dap[i][3] = dap[i-1][3];
				}
				for (int j = index	; j < line.length(); j++) {
					
					switch (line.charAt(j)) {
					case '(': dap[i][1]++; break;
					case ')': dap[i][1]--; break;
					case '{': dap[i][2]++; break;
					case '}': dap[i][2]--; break;
					case '[': dap[i][3]++; break;
					case ']': dap[i][3]--; break;
					}
				}
			}
			
			for (int i = 0; i < q; i++) {
				dap[i][0] = -2;
			}
			// 중복순열
			for (int R = 1; R < 21; R++) {
				for (int C = 1; C < 21; C++) {
					for (int S = 1; S < 21; S++) {
						if(check(R,C,S)) {// 마스터 코드
							cal(R,C,S);
						}
					}
				}
			}
			
			sb.append("#"+tc+" 0");
		
			for (int i = 1; i < dap.length; i++) {
				sb.append(" "+dap[i][0]);
			}sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static void cal(int R, int C, int S) {
		for (int i = 1; i < dap.length; i++) {
			int ans = dap[i-1][1]*R + dap[i-1][2]*C + dap[i-1][3]*S;
			if(dap[i][0] == -2) {
				dap[i][0] = ans;
				
			}else if(dap[i][0] != ans) {
				dap[i][0] = -1;
			}
		}
	}

	private static boolean check(int R, int C, int S) {
		for(int i = 1 ; i < m.length ; i++) {
			if(m[i][0] != m[i-1][1]*R + m[i-1][2]*C + m[i-1][3]*S) {
				return false;
			}
		}
		return true;
	}
}