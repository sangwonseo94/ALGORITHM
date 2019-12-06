#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int main(int argc, char** argv) {
	//freopen('')
	int n , min = 2147000000 , max = -1;
	cin >> n; 
	for ( int i = 0 ; i < n ; i ++){
		int temp; cin >> temp;
		if (temp > max) max =temp;
		if( temp < min) min =temp;
	}
	cout << max - min ;
	return 0;
}
