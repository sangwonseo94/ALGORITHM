package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class 공넣기 {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = br.readLine();
      Stack<Character> stack = new Stack<>();
      ArrayDeque<Integer> dq = new ArrayDeque<>();
      
      // 아이디어는 (와 [ 의 시작개수를 체크해서 덩어리가 끝났을때에 체크해줍니다.
      int sum = 0;
      int answer = 0;
      
      // partition_a == ( 의 개수를 체크하는 변수 b는 [
      int partition_a = 0;
      int partition_b = 0;
      
      // 중간에 강졔 종료
      boolean impossible = false;
      
      for (int i = 0; i < str.length(); i++) {
    	 // 그냥 넣어주면서 개수 체크
         if (str.charAt(i) == '(') {
            stack.push('(');
            partition_a+=1;
         } else if (str.charAt(i) == '[') {
            stack.push('[');
            partition_b+=1;
         } else if (!stack.isEmpty() && str.charAt(i) == ')') {
        	// 스택이 비어있지 않았을 때, )를 만난다면 정산 시작
        	 
        	if (stack.peek()=='(') {
        	   // 바로 닫히는 경우는 sum에 2를 더해주고 
               sum+=2;
               stack.pop();
               dq.add(sum);
               sum=0;
               partition_a--;
               
               if(partition_a ==0) {
            	   // 완전히 빌때까지 결합괄호 처리
            	   while(!dq.isEmpty()) answer +=dq.pop();
               } else {
            	   // 아직 완전한 덩어리 처리가 안된경우 ((( 더 깊이 들어간경우에는 
               }
               
            } else {
               impossible = true;
               break;
            }
         } else if (!stack.isEmpty() && str.charAt(i) == ']') {
            if (stack.peek().equals("[")) {
               stack.pop();
               if (str.charAt(i - 1) == '[') {
                  sum += 3;
               }
            } else {
               sum = 0;
               break;
            }
         } else {
            sum = 0;
            break;
         }
      }

      if (!stack.isEmpty()) {
         System.out.println(0);
      } else {
         System.out.println(sum);
      }

   }

}