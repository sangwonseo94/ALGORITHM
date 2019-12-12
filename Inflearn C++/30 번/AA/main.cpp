#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	int n , cnt = 0 ; 
	cin >> n;
	while( n > 0){
		cnt +=( n / 10);
		if( n % 10 >= 3) cnt ++;
		n /=10;
	}
	cout  << cnt;
	return 0;
}
