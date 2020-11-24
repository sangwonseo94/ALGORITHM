package leetcode;

public class reverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverse(Integer.MIN_VALUE));
		System.out.println(reverse(-123));
	}
	/**
	 * 
	 * @param x : 하나의 정수를 받고
	 * 뒤집은 수를 반환 1000 =>1
	 * @return
	 */
	public static int reverse(int x) {
		  StringBuilder sb = new StringBuilder();
	      boolean isMinus = x < 0 ? true : false;
	      x = Math.abs(x);
	      String num = Integer.toString(x);
	      boolean isZero = true;
	      for(int i = num.length()-1; i >=0 ; i --) {
	    	  if(num.charAt(i)=='0' && isZero) {
	    		  continue;
	    	  } else if(num.charAt(i)!='0'&&isZero) {
	    		  isZero = false;
	    	  } 
	    	  if( num.charAt(i) =='-') continue;
	    	  sb.append(num.charAt(i));
	      }
	      String answer = sb.toString();
	      if(isMinus) {
	    	  answer = '-' + answer;
	      }
	      // 예외처리
	      if(answer.length()==0) {
	    	  answer ="0";
	      }
	      if(Long.parseLong(answer) > Integer.MAX_VALUE || Integer.MIN_VALUE > Long.parseLong(answer)) {
	    	  answer ="0";
	      }
	      return Integer.parseInt(answer);
	}
}
