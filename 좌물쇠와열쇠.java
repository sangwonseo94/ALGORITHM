package algorithm;

public class 좌물쇠와열쇠 {

	public static void main(String[] args) {
		System.out.println(
		solution(new int[][] {{0,0,0},{1,0,0},{0,1,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}})
				);
	}

	
	public static boolean solution(int[][] key, int[][] lock) {
       
        int m = key[0].length;
        int n = lock[0].length;
        int arr_size = 2*m+n-1;
        int map[][] = new int[arr_size][arr_size];
        int copymap[][] = new int[arr_size][arr_size];
        for(int i = m-1 ; i <= m-1+n-1; i++) {
        	for(int j = m -1 ; j <= m-1+n-1 ; j++) {
        		copymap[i][j] = map[i][j] = lock[i - (m-1)][j-(m-1)];
        	}
        }
        
        
        for(int i = 0 ; i<= m+n-2 ; i++) {
        	for(int j = 0 ; j <= m+n-2; j++) {
        		for(int k = 0 ; k <4 ; k ++) {
        		key = rotate(key);	
        		boolean chk = true;
        		// i,j에서 부터 M,M 까지  회전 배열을 덮어 씌운다.
        		top :
        		for(int a = i ;a <= i+m-1; a++) {
        			for(int b = j ; b <= j+m-1; b++) {
        				if( (a>=m-1 && a<=m+n-2) && (b >=m-1 && b<=m+n-2)){
        					if(copymap[a][b]==0) {
        						copymap[a][b] = key[a-i][b-j];
        					} 
        					else if(key[a-i][b-j] == 1 && copymap[a][b] ==1){
        						// 1이 곂치는 경우
        						chk = false;
        						break top;
        					}
        				} else {
        					copymap[a][b] = key[a-i][b-j];
        				}
        			}
        		}
        		if(chk) {
	        		int cnt = 0;
	        		top :
	        		for(int a = m-1 ; a <= m-1+n-1; a++) {
	        	        for(int b = m -1 ; b <= m-1+n-1 ; b++) {
	        	        	if( copymap[a][b]==1) {
	        	        		cnt++;
	        	        	} else {
	        	        		break top;
	        	        	}
	        	        }
	        	     }
	        	      if(cnt == n*n) {
	        	    	  return true;
	        	      }
        		}
	    		// rollback
	    		for(int a = i ;a <= i+m-1; a++) {
	    			for(int b = j ; b <= j+m-1; b++) {
	    			   copymap[a][b] = map[a][b];
	    			}
	    		}
        		}
        	}
        }
        
        return false;
    }


	private static int[][] rotate(int[][] key) {
		//key 배열을 90만큼 누적 회전 
		int key_size = key[0].length;
		int rotated_key[][] = new int[key_size][key_size];
		for(int i = 0 ; i < key_size ; i ++) {
			for(int j = 0 ; j < key_size ; j++) {
				rotated_key[j][(key_size-1)-i] = key[i][j];
			}
		}
		return rotated_key;
	}    
	
}
