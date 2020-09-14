package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이차원배열과연산 {
	
	public static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[1]>o2[1]) return 1;
			else if(o1[1]<o2[1]) return -1;
			else {return o1[0]-o2[0];}
		}
	});
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		int map[][] = new int[3][3];
		for(int i=0;i<3;i++) {st=new StringTokenizer(br.readLine());for(int j=0;j<3;j++)map[i][j]=Integer.parseInt(st.nextToken());}
		int answer = -1;
		for(int i=0;i<=100;i++){
			int y=map.length;int x=map[0].length;
			if(x>100) {for(int yyy=0;yyy<y;yyy++) map[yyy]=Arrays.copyOfRange(map[yyy], 0, 100);}
			else if(y>100){
				int cmap[][] =new int[100][x];
				for(int yyy=0;yyy<100;yyy++)cmap[yyy]=map[yyy].clone();
				map=cmap;
			}
			if(r<y && c<x && map[r][c]==k) {answer=i;break;}
			if(y>=x) { // r연산
				int maxsize=-1; 
				for(int yy=0;yy<y;yy++) {map[yy] = compute(map[yy]);maxsize = maxsize > map[yy].length ? maxsize : map[yy].length;}
				for(int yy=0;yy<y;yy++) {int row[] = new int[maxsize];for(int xx=0;xx<maxsize;xx++) {if(xx<map[yy].length) row[xx]=map[yy][xx];}map[yy] =row;}
			}else {
				int tempmap[][]=new int[x][y]; int maxsize =-1;
				for(int xx=0;xx<x;xx++) {int col[]= new int[y]; for(int yy=0;yy<y;yy++) {col[yy] = map[yy][xx];}col = compute(col);maxsize = maxsize > col.length ? maxsize : col.length;tempmap[xx] = col;}
				map = new int[maxsize][x];
				for(int xx=0;xx<x;xx++) {
					int col[] = new int[maxsize];
					for(int yy=0;yy<tempmap[xx].length;yy++) {col[yy] = tempmap[xx][yy];}
					for(int yy=0;yy<maxsize;yy++) {	map[yy][xx] = col[yy];}
				}
			}
		}System.out.println(answer);
		
		
	}
	private static int[] compute(int[] is) {
		if(is.length >100) is= Arrays.copyOfRange(is, 0, 100);
		int number=0;int show=0;
		Arrays.sort(is);
		for(int i=0;i<is.length;i++) {
			if(is[i]==0) continue;
			if(number==0&&show==0){number=is[i];show=1;}
			else if(number==is[i]&&show!=0)show++;
			else {pq.add(new int[] {number,show}); number=is[i];show=1;}
		}
		pq.add(new int[] {number,show});
		int res[] = new int[pq.size()*2]; int index=0;
		while(!pq.isEmpty()) {int[]now =pq.poll();res[index++]=now[0];res[index++]=now[1];}
		return res;
	}
}

