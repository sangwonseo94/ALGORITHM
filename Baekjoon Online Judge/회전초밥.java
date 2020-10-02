package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 회전초밥 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int answer =0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		int dish[] = new int[n]; for(int i=0;i<n;i++) {dish[i] = Integer.parseInt(br.readLine());}
		if(n <= k) {
			// 서로다른것을 모두 먹을수 있다.
			for (int i : dish) {if(!hm.containsKey(i)) hm.put(i, 1);}
			answer = hm.keySet().size();
		} else {
			int s =0;
			int e =k;
			for(;s<k;s++) {
				if(hm.containsKey(dish[s])) {
					hm.put(dish[s],hm.get(dish[s])+1);
				} else {
					hm.put(dish[s] , 1);
				}
			} //초기상태
			s=0;e=k-1;
			while(!(s%n==0) ) {
				
				int ss = s%n;
				int ee = e%n;
				// 하나삭제..
				hm.put(dish[ss],hm.get(dish[ss])-1);
				if(hm.get(dish[ss])==0) hm.remove(dish[ss]);
				if(hm.containsKey(dish[ee])) {
					hm.put(dish[ee],hm.get(dish[ee])+1);
				} else {
					hm.put(dish[ee],1);
				}
				int max = hm.containsKey(c) ? 0 : 1;
				answer = answer > max + hm.keySet().size() ? answer : max + hm.keySet().size() ;
				s++;e++;
			}
		}
		System.out.println(answer);
	}

}
