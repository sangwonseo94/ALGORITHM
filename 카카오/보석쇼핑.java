package 카카오;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 보석쇼핑 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"A","B","C","A","B","C","A","B","C","E"})));
		System.out.println(Arrays.toString(solution(new String[] {"A","B","C","A","B","C","A","B","C","E"})));
	}
	
	 public static int[] solution(String[] gems) {
	        
	        int cnt=0;
	        HashSet<String> hs = new HashSet<>();
	        int gsize = gems.length;
	        for(int i  = 0 ; i < gsize ;  i++) {hs.add(gems[i]);}
	        int size = hs.size();
	        int end = 0 , start=0; 
	        HashMap<String, Integer> hm  = new HashMap<>();
	        for(int i = 0 ; i < gsize ; i++) {
	        	if(hm.containsKey(gems[i])) {
	        		hm.put(gems[i], 1+hm.get(gems[i]));
	        	} else {
	        		hm.put(gems[i] , 1);
	        	}
	        }
	     
	        int answer[] = new int[] {start+1 , end+1};
	        return answer;
	}

}
