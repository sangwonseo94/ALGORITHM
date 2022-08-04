package programmers;

public class programmersAlgoTest_part2_first {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		// System.out.println(solution(new int[] {-2,3,0,2,-5}));
		// System.out.println(solution(new int[] {-3,-2,-1,0,1,2,3}));
		System.out.println(solution(new int[] {-1,1,-1,1}));

	}
	public static int answer =0 , size;
	public static int numbers[];
	public static int solution(int[] number) {
	   numbers = number.clone();
	   size = number.length;
	   dfs(0,0,0);
	   
	   return answer;
	}
	public static void dfs(int sum, int index, int cnt) {
		if(cnt==3) {
			if(sum == 0) {
				answer ++;
			} 
			return;
		} else {
		   for(int i=index;i<size;i++) {
			   if(cnt < 3) {
				   dfs(sum+numbers[i] , i+1 , cnt+1);
			   }
		   }
		}
		
	}

}
