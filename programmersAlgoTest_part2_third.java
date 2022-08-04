package programmers;

import java.util.HashSet;
import java.util.Set;

public class programmersAlgoTest_part2_third {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
	    System.out.println(solution(new int[] {1,2,1,3,1,4,1,2}));
		System.out.println(solution(new int[] {1,2,3,1,4}));
		

	}

	public static int solution(int[] topping) {
	   int answer = 0;
	   int len = topping.length;
	   HashSet<Integer> hs = new HashSet<>();
	   int f[] = new int[len];
	   int b[] = new int[len];
	   for(int i=0;i<len;i++) {
		   hs.add(topping[i]);
		   f[i] = hs.size();
	   }
	   hs.clear();
	   for(int i=len-1;i>=0;i--) {
		   hs.add(topping[i]);
		   b[i] = hs.size();
	   }
	   
	   for(int i=0;i<len;i++) {
		   if(i+1<len) {
			  if( f[i] == b[i+1]) {
				  answer++;
			  }
		   }
	   }
	   
	   return answer;
	}

}
