package 풀문제;

public class np {

	
	private static boolean np() {
		int i = n-1 ;
		while(i > 0 && p[i-1] > p[i]) i--;
		if(i==0) return false;
		int j = n-1;
		while(p[i-1] >= p[j]) j--;
		
		int tmp = p[i-1];
		p[i-1] = p[j];
		p[j] =tmp;
		
		// i위치부터 맨뒤깢 ㅣ내림차순을 오름차순으로 변경 ( 제일 작은 숫자 )
		int k = n-1;
		while(i<k) {
			tmp =p[i];
			p[i]= p[k];
			p[k] =tmp;
			i++;--k;
		}
		
		
		
		return true;
	}
}
