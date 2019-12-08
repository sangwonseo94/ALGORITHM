#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	int N, player[10001]; 
	cin >> N;
	for( int i = 0; i < N ; i++){
		cin >> player[i];
		if( i == 0){
			cout << "1 ";
		}
		else{
			int cnt = 0;
			for(int j = 0 ; j <= i; j++){
				if(player[j] >= player[i]){
					cnt++;
				}
			}
			cout << cnt <<" ";
		}
	}
	
	return 0;
}
