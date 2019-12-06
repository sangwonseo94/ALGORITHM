#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	int N , M , result = 0 ;
	cin >> N >> M ; 
	for ( int i = 1; i <=N ; i++){
		
		if(i%M == 0){
			result += i;
		}
	}
	cout << result ; 
	return 0;
}
