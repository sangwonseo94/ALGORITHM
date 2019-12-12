#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	int score[101];
	int N;
	cin >> N; 
	for ( int i = 0 ; i < N; i ++){
		cin >> score[i];		
	}
	for (int i = 0 ; i < N ; i ++){
		int temp = score[i];
		for (int j = i+1 ; j < N ; j ++){
			if( temp < score[j]){
				int t ; 
				t = score[j];
				score[j] = temp;
				temp = t;
			}
		}
		score[i] =temp;
	}
	int before = score[0] , cnt = 0;
	for(int i = 0 ; i < N ; i++){
		if(before == score[i]) continue;
		else{
			cnt ++;
			before = score[i];
		}
		if ( cnt == 2){
			cout << score[i];
			break;
		}
	}
	return 0;
}
