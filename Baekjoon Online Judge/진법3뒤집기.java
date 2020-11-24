package algorithm;

public class 진법3뒤집기 {

	public static void main(String[] args) {
		
		
		System.out.println(solution(45));
	}
	public static int solution(int n){
		String t = Integer.toString(n, 3);
		String answer = "";
		for(int tt = t.length()-1 ; tt>=0 ;tt--) {answer+= t.charAt(tt);}
		int res =0;
		for(int i=answer.length()-1 , mul = 1; i>=0; i-- , mul *=3) {
			res += (answer.charAt(i)-'0')*mul;
		}
		return res;
	}
}
