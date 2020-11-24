package CodeForce0904;

import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int length = query.length;
		int[] answer = new int[length];
		
		Map<String, Map<Integer, Integer>> map = new HashMap<String, Map<Integer, Integer>>();
		
		
		for (String qquery : query) {
			StringTokenizer st = new StringTokenizer(qquery," ");
			String language = st.nextToken();
			st.nextToken();
			String position = st.nextToken();
			st.nextToken();
			String career = st.nextToken();
			st.nextToken();
			String soulFood = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			String key = language+" "+position+" "+career+" "+soulFood;
			if(!map.containsKey(key)) {
				map.put(key, new HashMap<Integer, Integer>());
			}
			map.get(key).put(score, 0);
		}
		
		for (String iinfo : info) {
			StringTokenizer st = new StringTokenizer(iinfo, " ");
			String[] langs = {"-", st.nextToken()};
			String[] positions = {"-", st.nextToken()}; 
			String[] careers = {"-", st.nextToken()}; 
			String[] soulFoods = {"-", st.nextToken()};
			int score = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					for (int l = 0; l < 2; l++) {
						for (int m = 0; m < 2; m++) {
							String key = langs[j]+" "+positions[k]+" "+careers[l]+" "+soulFoods[m];
							if(!map.containsKey(key)) {
								continue;
							}
							Map<Integer, Integer> tmp = map.get(key);
							for (int s : tmp.keySet()) {
								if(s <= score) {
									tmp.put(s, tmp.get(s) + 1);
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < length; i++) {
			StringTokenizer st = new StringTokenizer(query[i], " ");
			String language = st.nextToken();
			st.nextToken();
			String position = st.nextToken();
			st.nextToken();
			String career = st.nextToken();
			st.nextToken();
			String soulFood = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			String key = language+" "+position+" "+career+" "+soulFood;
			answer[i] = map.get(key).get(score);
		}
		return answer;
    }
}






