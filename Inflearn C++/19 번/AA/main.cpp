#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	
	int N,cnt=0,max = -1; cin >> N;
	int stud[N];
	for(int index= 0 ;index <N  ; index++){
		int temp; cin >> temp;
		stud[index] =temp;
	}	
	for( int index = N-1 ; index >=0 ; index--){
		if(stud[index] > max){
			max = stud[index];
			cnt ++;
		}
	}
	cout << cnt-1 ;
	return 0;
}
