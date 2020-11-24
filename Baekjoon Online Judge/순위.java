package algorithm;

public class 순위 {

	public static void main(String[] args) {
	
		System.out.println(solution(8, new int[][] {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8}}));
	}
	
	  public static int solution(int n, int[][] results) {
	        int answer = 0;
	        int largeN = 987654321;
	        int map[][] = new int[n+1][n+1];
	        int imap[][] = new int[n+1][n+1];
	        for(int i=1;i<=n;i++) {for(int j=1;j<=n;j++) {if(i==j)continue;map[i][j] = largeN;imap[i][j] = largeN;}}
	        for(int i=1;i<=results.length;i++) {map[results[i-1][0]][results[i-1][1]]=1;imap[results[i-1][1]][results[i-1][0]]=1;}
	        for(int mid=1;mid<=n;mid++)for(int start=1;start<=n;start++) {
	        	for(int end=1;end<=n;end++) {
	        		if(!(map[start][mid] ==largeN||map[mid][end]==largeN)) {
	        		if(map[start][end] > map[start][mid] + map[mid][end]) {
	        			map[start][end] = map[start][mid] + map[mid][end];}}
	        		if(!(imap[start][mid]==largeN ||imap[mid][end]==largeN)) {
	        		if(imap[start][end] > imap[start][mid] + imap[mid][end]){
	        			imap[start][end] = imap[start][mid] + imap[mid][end];}}
	        	}
	        }
	        for(int i=1;i<=n;i++) {
	        	int cnt=0;
	        	for(int j=1;j<=n;j++) {
	        		if(i==j) continue;
	        		if(map[i][j]!=largeN)cnt++;
	        		if(imap[i][j]!=largeN)cnt++;
	        	}
	        	if(cnt+1==n)answer++;
	        }
	        return answer;
	    }

}
