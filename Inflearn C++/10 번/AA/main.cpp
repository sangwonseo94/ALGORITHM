#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int num[50001];
int main(int argc, char** argv) {
	int n; cin >> n ;
	
	for (int index = 1 ; index <= n; index ++){
		for (int i = index ; i <= n ; i += index){		
			num[i]++;
		}
	}
	for ( int index = 1;  index <=n ; index ++) cout<< num[index] <<" " ;

	return 0;
}
