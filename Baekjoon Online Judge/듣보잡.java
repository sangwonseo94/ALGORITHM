package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 듣보잡 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> HM = new HashMap<>();
		HashMap<String, Integer> HM2 = new HashMap<>();
		for(int i=0;i<n;i++) {HM.put(br.readLine(), 0);}
		for(int i=0;i<m;i++) {HM2.put(br.readLine(), 0);}
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (String string : HM.keySet()) {if(HM2.containsKey(string)) {pq.add(string);}}
		StringBuilder sb = new StringBuilder(); sb.append(pq.size()+"\n");
		while(!pq.isEmpty()) {sb.append(pq.poll()+"\n");	}
		System.out.println(sb);
		
	}

}
