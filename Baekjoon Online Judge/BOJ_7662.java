package algorithm_2022;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.io.BufferedReader;

public class BOJ_7662 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=0;t<tc;t++) {
			
			st    = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			for(int i=0;i<n;i++){
				
				st     = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
			    int  m = Integer.parseInt(st.nextToken());
			    
				if(c=='I') {
					if(tm.getOrDefault(m, 0)==0) {
						tm.put(m, 1);
					} else {
						tm.put(m, tm.get(m)+1);
					}
				} else {
					if(tm.keySet().size()==0) {
						continue;
					}
					if(m==1){
						int l = tm.lastKey();
						if(tm.get(l) > 1) {
						    tm.put(l, tm.get(l)-1);
						} else {
							tm.remove(l);
						}
					} else {
						int f = tm.firstKey();
						if(tm.get(f) > 1) {
						    tm.put(f, tm.get(f)-1);
						} else {
							tm.remove(f);
						}
					}
				}
			}
			
			if(tm.keySet().size()==0) {
				sb.append("EMPTY\n");
			} else {
				sb.append(tm.lastKey()+" "+tm.firstKey()+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
