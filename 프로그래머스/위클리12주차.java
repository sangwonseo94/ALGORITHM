
public class 위클리12주차 {

	public static void main(String[] args) {
		
	}
	public static int result = -1;
	public static int solution(int k, int[][] dungeons) {
	        return answer(k,dungeons,0,new boolean[dungeons.length]);
	}
	private static int answer(int k, int[][] dungeons, int i, boolean[] bs) {
		result=i >result ?i:result;
		for(int j=0;j<dungeons.length;j++){
			if(!bs[j]&&dungeons[j][0]<=k) {
				bs[j]=true;
				answer(k-dungeons[j][1],dungeons,i+1,bs);
				bs[j]=false;
			}
		}
		return result;
	}
}
