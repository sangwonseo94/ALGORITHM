package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 친구네트워크 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < t ; i++) {
			st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			HashMap<String, Integer> hs = new HashMap<>();
			
			HashMap<Integer, ArrayList<String>> nameMap = new HashMap<>();
			for(int j = 0 ; j < tc ; j++) {
				st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if(!hs.containsKey(name1) && !hs.containsKey(name2)) {
					// 둘다 없는 경우  j+1로 add
					hs.put(name1, j+1);
					hs.put(name2, j+1);
					nameMap.put(j+1, new ArrayList<String>());
					nameMap.get(j+1).add(name1);
					nameMap.get(j+1).add(name2);
					sb.append("2\n");
				} else if (!hs.containsKey(name1) && hs.containsKey(name2)) {
					int idx = hs.get(name2);
					hs.put(name1, idx);
					nameMap.get(idx).add(name1);
					sb.append(nameMap.get(idx).size() +"\n");
				} else if (!hs.containsKey(name2) && hs.containsKey(name1)) {
					int idx = hs.get(name1);
					hs.put(name2, idx);
					nameMap.get(idx).add(name2);
					sb.append(nameMap.get(idx).size() +"\n");
				} else {
					// 둘다있는경우 큰 쪽으로 Union 해준다.
					
					int idx_1 = hs.get(name1);
					int idx_2 = hs.get(name2);
					if(idx_1==idx_2) {
						sb.append(nameMap.get(idx_1).size() +"\n");
					} else {
						if(nameMap.get(idx_1).size() > nameMap.get(idx_2).size()) {
							for(int k = 0 ; k < nameMap.get(idx_2).size() ; k++) {
								String now = nameMap.get(idx_2).get(k);
								hs.put(now, idx_1);
								nameMap.get(idx_1).add(now);
							}
							nameMap.remove(idx_2);
							sb.append(nameMap.get(idx_1).size() +"\n");
						} else {
							for(int k = 0 ; k < nameMap.get(idx_1).size() ; k++) {
								String now = nameMap.get(idx_1).get(k);
								hs.put(now, idx_2);
								nameMap.get(idx_2).add(now);
							}
	
							nameMap.remove(idx_1);
							sb.append(nameMap.get(idx_2).size() +"\n");
						}
					}
				}
			}
		}System.out.println(sb);
	}

}
