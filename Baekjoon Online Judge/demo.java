package 풀문제2;

import java.util.ArrayList;
import java.util.Arrays;

public class demo {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(
		solution(new int[][] {{1,4},{3,4},{3,10}})
				));
	}

	 public static int[] solution(int[][] v) {
	     
		 int answer[] = new int[2];
		 ArrayList<Integer> al = new ArrayList<>();
		 for(int i = 0 ; i < v.length ; i++) {
			 if(!al.contains(v[i][0])) {
				 al.add(v[i][0]);
			 } else {
				 al.remove(new Integer(v[i][0]));
			 }
		 }

		 answer[0] = al.get(0);
		 al.clear();
		 for(int i = 0 ; i < v.length ; i++) {
			 if(!al.contains(v[i][1])) {
				 al.add(v[i][1]);
			 } else {
				 al.remove(new Integer(v[i][0]));
			 }
		 }
		 answer[1] = al.get(0);
		 return answer;
	    }
}
