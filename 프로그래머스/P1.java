package 프로그래머스월간코드챌린지;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P1 {

	public static void main(String[] args) {
		solution(new int[] {2,1,3,4,1});
		solution(new int[] {5,0,2,7});
	}
	
	 public static int[] solution(int[] numbers) {
	        int[] answer;
	        ArrayList<Integer> al = new ArrayList<>();
	        int cnt =0;
	        HashMap<Integer, Integer> hm = new HashMap<>();
	        for(int i=0;i<numbers.length;i++) {
	        	for(int j=i+1;j<numbers.length;j++) {
	        		if(!hm.containsKey(numbers[i]+numbers[j])) {
	        			hm.put(numbers[i]+numbers[j], numbers[i]+numbers[j]);
	        				al.add(numbers[i]+numbers[j]);
	        			cnt++;
	        		}
	        	}
	        }
	        answer = new int[cnt];
	        Collections.sort(al);
	        for(int i=0;i<al.size();i++) {
	        	answer[i] = al.get(i);
	        }
	        
	        return answer;
	 }
}
