package 푼문제;


import java.util.Scanner;
import java.io.FileInputStream;

class dalpang_{
    static int number = 1 ,  x = 0 , y = 0 , End=0  ;
	public static void main(String args[]) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int T; T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
		
		int N = sc.nextInt();
		int map[][] = new int[N][N];
		int bound = N;
   		if(N%2 ==1)map[N/2][N/2] = N*N;
     
		
        while( (N - End) >= 2) {
                for( ; x < N-1 ; x++) {map[y][x] =number; number++;}
                for( ; y < N-1 ; y++) {map[y][x] =number; number++;}
                for( ; x > End ; x--) {map[y][x] =number; number++;}
                for( ; y > End ; y --){map[y][x] =number; number++;}
                x++; y++;
                N -=1;
                End +=1;
            } 
        
        ///���
        System.out.println("#"+test_case);
        for(int j = 0 ; j <bound ; j ++) {
            for(int i = 0 ; i <bound ; i ++) {
                System.out.print(map[j][i]+ " ");
            }
          System.out.println();
        }
        ///���Է�
        number = 1; 
        x = 0; 
        y = 0;
        End=0;
		}
	}
}