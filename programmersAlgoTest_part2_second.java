package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class programmersAlgoTest_part2_second {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
	    System.out.println(Arrays.toString(solution(3, new int[][] {{1,2},{2,3}}, new int[] {2,3},1)));
		System.out.println(Arrays.toString(solution(5, new int[][] {{1,2},{1,4},{2,4},{2,5},{4,5}},new int[] {1,3,5},5)));
		

	}

	public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
		destination--;
        // dest에서 각 1-n까지의 최단거리 구하기 bfs
        ArrayList<Integer> map[]; map = new ArrayList[n];
        for(int i=0;i<n;i++) {map[i] = new ArrayList<>();}
        
        for(int i=0;i<roads.length;i++) {
        	map[roads[i][0]-1].add(roads[i][1]-1);
        	map[roads[i][1]-1].add(roads[i][0]-1);
        }
        
        int[] path = new int[n];
        for(int i=0;i<n;i++)path[i] = 987654321;
        
        path[destination] = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();dq.add(destination);
        while(!dq.isEmpty()) {
        	int now = dq.poll();
        	for(int i=0;i<map[now].size();i++) {
        		int next = map[now].get(i);
        		if(path[next] > path[now]+1) {
        			path[next] = path[now]+1;
        			dq.add(next);
        		}
        	}
        }
        int size = sources.length;
        int[] answer = new int[size];
        for(int i=0;i<size;i++) {
        	answer[i] = path[sources[i]-1] == 987654321 ? -1 : path[sources[i]-1];
        }
        return answer;
    }

}
