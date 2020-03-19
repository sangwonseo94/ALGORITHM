package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class ����Ÿ�� {
	static int answer=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int tc=1; tc <= t ; tc++) {
			
			ArrayDeque<Integer> order = new ArrayDeque<>();
			ArrayDeque<Integer> wait = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int spot[] = new int[n+1];
			int cost[] = new int[m+1];
			for(int index =1 ; index <=n ; index++) {
				st = new StringTokenizer(br.readLine());
				spot[index] = Integer.parseInt(st.nextToken());
			}
			for(int index =1; index <=m ; index++) {
				st = new StringTokenizer(br.readLine());
				cost[index] = Integer.parseInt(st.nextToken());
			}

			for(int index =1; index <=m*2 ; index++) {
				st = new StringTokenizer(br.readLine());
				order.add(Integer.parseInt(st.nextToken()));
			}
			int visit[] = new int[n+1];
			
			for(int index = 0 ;index <=n ; index++) visit[index] =0;
			int idx =0;
			while(!order.isEmpty()) {
				idx =0; 
				
				for(int index =1 ; index <=n ; index++) {
					if(visit[index] ==0) {
						idx = index;
						break;
					}
				}
				if(!wait.isEmpty() && idx !=0 ) {
					int g = wait.poll();
					visit[idx] = g;
					continue;
				}
				int pos = order.poll();
				if(idx==0 && pos>0) {
					wait.add(pos);
					//��á�ٴ� ����
					//��⿭�� �־���
					continue;
				}
				if(pos <0) {
					//������ �� �ڸ� �湮ó���� �ٲپ��ְ� 
					//�� ��� // 
					int temp=0;
					for(int index= 1; index<=n ; index++) {
						if(visit[index]== (-pos)) {
							temp = index; break;
						}
					}
					answer+= spot[temp]*cost[-pos];
					visit[temp] =0;
					continue;
				}
				
				if(pos>0) {
					// ����ִ� idx�� ���� ������ �־���
					//now[idx] = cost[pos];
					visit[idx] = pos;
					// �ִٴ� ǥ��
				}
				
			}
			sb.append("#"+tc+" "+answer+"\n");
			answer =0;
		}
		System.out.println(sb);
	}

}
