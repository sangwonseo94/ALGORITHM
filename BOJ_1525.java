package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1525 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	
		
		HashMap<ArrayList, Integer> visit = new HashMap<>();
        
		int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
		ArrayDeque<ArrayList<Integer>> dq = new ArrayDeque<>();
		
		ArrayList<Integer> al = new ArrayList<>();
	
		for(int i=0;i<3;) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;) {
				int now = Integer.parseInt(st.nextToken());
				al.add(now);
				++j;
			}
			++i;
		}
		int cnt =0;
		dq.add(al);
		visit.put((ArrayList<Integer>)al.clone(),0);
		while(!dq.isEmpty()) {
			int size = dq.size();
			cnt++;
			while(size>0) {
				
				al = dq.poll();
				int index = findZeroPos(al);
				int y = index/3;
				int x = index%3;
				for(int i=0;i<4;) {
					int nexty=y+dir[i][0];
					int nextx=x+dir[i][1];
					if(nexty>=0&&nextx>=0&&nexty<3&&nextx<3) {
						Collections.swap(al, y*3+x, nexty*3+nextx);
						if(!visit.containsKey(al)) {
							dq.add((ArrayList<Integer>) al.clone());
							visit.put((ArrayList<Integer>) al.clone(), cnt);
						}
						Collections.swap(al, nexty*3+nextx ,y*3+x);
					}
					++i;
				}
				size--;
			}
		}
		al.clear();
		for(int i=1;i<=8;) {
			al.add(i);
			++i;
		}
		al.add(0);
		if(visit.containsKey(al)) {
			System.out.println(visit.get(al));
		} else {
			System.out.println("-1");
		}
	}

	private static int findZeroPos(ArrayList<Integer> al) {
		int size =al.size();
		for(int i=0;i<size;) {
			if(al.get(i)==0) return i;
			++i;
		}
		return -1;
	}
}
