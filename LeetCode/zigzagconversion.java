package leetcode;

public class zigzagconversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING",3));
		System.out.println(convert("PAYPALISHIRING",1));
	}
	 public static String convert(String s, int numRows) {
		 if(s.length()==0) return "";
	     if(numRows==1) return s;
	     char c[] =s.toCharArray();
	     char map[][] = new char[numRows][s.length()];
	     int y=0,x=0,i=1;
	     map[0][0] = c[0];
	     int size = s.length();
	    
	     top :
	     while(i < size) {
	    	 while( y+1 < numRows ) {
	    		 if(i < size) map[++y][x] = c[i++];
	    		 else break top;
	    	}
	    	 while( y-1 >= 0) {
	    		 if( i < size) map[--y][++x] = c[i++];
	    		 else break top;
	    	}
	    }
	    StringBuilder sb = new StringBuilder();
	   
	    for(int yy=0;yy<numRows;yy++) {
	    	for(int xx=0;xx<s.length();xx++) {
	    		if(map[yy][xx]!='\0') {
	    			sb.append(map[yy][xx]);
	    		}
	    	}
	    }
	    return sb.toString();
	  }
}
