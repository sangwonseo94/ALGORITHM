#include <iostream>
#define MAX 17
using namespace std;
int N,res;
int map[MAX][MAX];
pair<int,int> dir[3] ={
	{0,1},
	{1,0},
	{1,1}
};
void input(){
	cin>>N;
	for(int y= 0 ; y < N ;y++){
		for(int x =0; x < N ; x++){
			cin >> map[y][x];
		}
	}
}

void compute(int y, int x, int state){
	if(y == N-1 && x == N-1) res++;
	for(int i = 0 ; i < 3 ; i ++){
		
		if( (state == 0 && i ==1) || (state==1 && i==0) )continue;
		
		int ny = y + dir[i].first;
		int nx = x + dir[i].second;
		
		if(ny < 0 || nx <0 || ny >=N || nx>= N ) continue;
		if(map[ny][nx]) continue;
		if(i ==2){
			if(map[ny-1][nx] || map[ny][nx-1]) continue;
		}
		
		compute(ny,nx,i);
		
	}	
	
	return;
}


int main(void){
	input();	
	compute(0,1,0);
	cout<< res;
	return 0;
}
