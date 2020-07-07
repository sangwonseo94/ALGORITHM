package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 퍼즐_풀이중 {
	public static class node {
		String str ; int idx ;

		public node(String str, int idx) {
			super();
			this.str = str;
			this.idx = idx;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int index = 0;
		for(int i = 0 ; i < 3 ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j ++) {
				str+=st.nextToken();
				if(str.charAt(str.length()-1) =='0') {
					index = i * 3 + j;
				}
			}
		}
		HashMap<String, Boolean> hs = new HashMap<>();
		hs.put(str, true);
		ArrayDeque<node> dq = new ArrayDeque<>();
		dq.add(new node(str,index));
		int cnt=0;
		int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
		while(!dq.isEmpty()) {
			int size = dq.size(); cnt++;
			while(size > 0) {
				node now = dq.poll();
				int idx = now.idx;
				int y = idx/3;
				int x = idx%3;
				for(int i = 0 ; i < 4; i ++) {
					int ny = y + dir[i][0];
					int nx = x + dir[i][1];
					if(ny < 3 && nx <3 && nx >=0 && ny >=0 ) {
						char temp = now.str.charAt(idx);
						now.str.charAt(idx) = now.str.charAt(ny*3+nx);
						now.str.charAt(ny*3+nx) = temp;
					}
				}
			}
		}
	}
}
