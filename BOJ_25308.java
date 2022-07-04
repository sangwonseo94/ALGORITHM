package algorithm_2022;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_25308{
	public static int input[] = new int[8];
	public static int order[] = {0,1,2,3,4,5,6,7};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<8;i++) {input[i] = Integer.parseInt(st.nextToken());}
		int answer=0;
		do {

		    boolean isPossible = true;
			for(int i=0;i<8;i++) {
			
				float result_ccw = ccw(
						                   new float[] { (float) - (input[order[i%8]] / Math.sqrt(2)),  (float) (input[order[i%8]] / Math.sqrt(2)) }
					                     , new float[] { (float)   0  ,  (float) (input[order[(i+1)%8]])}
					                     , new float[] { (float)  (input[order[(i+2)%8]] / Math.sqrt(2)),  (float) (input[order[(i+2)%8]] / Math.sqrt(2))}
					                   );
				if(result_ccw >= 0) {
					isPossible =false;
				}
				if(!isPossible) {
					break;
				}
			}
			
			
					
			
			if(isPossible) {
				answer++;
			}
		} while(nextPermutation(order));
		System.out.println(answer);
	}
	

	public static float ccw(float []a, float []b, float []c) {
		// ccw 계산 , 일직선에 올수 없다( 정수이기 때문 )
		return (a[0]*b[1]+b[0]*c[1]+c[0]*a[1])-(b[0]*a[1]+c[0]*b[1]+a[0]*c[1]);
		
	}
	static boolean nextPermutation(int[] arr) {
		
		// step1
		int i=7;
		while( i>0 && arr[i-1] >= arr[i] ) --i; 
		
	    //i가 0이라는 말은 이 순열이 내림차순 형태로 정렬되어 있다는 것.
	    //다음 순열이 없는 경우이기 때문에 false를 반환해준다.
		if(i==0) return false;
		
		//step2
	    //내가 찾은 교환위치와 교환할 큰 값을 찾는 과정이다.
		int j = 7;
		while(arr[i-1]>=arr[j]) --j;
		
		//step3
	    //j와 i-1번째의 배열 값을 서로 교환해준다.
		int temp = order[i-1];
		order[i-1] = order[j];
		order[j] = temp;
		
		//step4
	    //i부터 맨뒤에까지를 오름차순으로 교환해준다.
		int k = 7;
		while(i<k) {
		    temp=order[i];
		    order[i]=order[k];
		    order[k]=temp;
			++i; --k;
		}
		return true;		
	}
}

