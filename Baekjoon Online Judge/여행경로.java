package 풀문제2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class 여행경로 {

	public static void main(String[] args) {
		System.out.println(
				solution(new String[][] {{"ICN","BOO"} , {"ICN" ,"COO"} , {"COO" ,"DOO"} , {"DOO" ,"COO"}
				, {"BOO" ,"DOO"} , {"DOO" ,"BOO"} , {"BOO" ,"ICN"} , {"COO" ,"BOO"} })
				);
	}

	static  int map[][];
	static  boolean visit[][];
	static  StringBuilder sb = new StringBuilder() ;
	static  HashMap<String, Integer> indexing_Map ;
	static  HashMap<Integer, String> find_indexing;
	static  int [] save_index;
	
	private static String solution(String[][] strings) {
		ArrayList<String> sortedNational = new ArrayList<>();
		indexing_Map = new HashMap<>();
		find_indexing = new HashMap<>();
		
		HashSet<String> Map_size = new HashSet<>();
		for(int i = 0 ; i < strings.length ; i ++) {
			if(!Map_size.contains(strings[i][0])) {sortedNational.add(strings[i][0]);}
			if(!Map_size.contains(strings[i][1])) {sortedNational.add(strings[i][1]);}
			Map_size.add(strings[i][0]);
			Map_size.add(strings[i][1]);
		}
		int size = Map_size.size();
		map        = new int    [size][size];
		visit      = new boolean[size][size];
		save_index = new int[size];
		
		
		Collections.sort(sortedNational);
		
		for(int i = 0 ; i < size ; i ++) {
			if(!indexing_Map.containsKey(sortedNational.get(i))) {
				indexing_Map.put(sortedNational.get(i), i);
				find_indexing.put(i,sortedNational.get(i));
			}
		}
		
		for(int i = 0 ; i < strings.length ; i++) {
			int start = indexing_Map.get(strings[i][0]);
			int end   = indexing_Map.get(strings[i][1]);
			map[start][end] += 1;
		}
		sb.append("ICN ");
		DFS(indexing_Map.get("ICN") , size);
		return sb.toString();
	}

	private static void DFS(int i , int size) {
		int s = save_index[i];
		for(int start = 0 ; start < size ; start++) {
			if(map[i][start] > 0) {
				save_index[i] = start;
				map[i][start]--;
				sb.append(find_indexing.get(start) + " ");
				DFS(start , size);
			}
		}
	}
}
