#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	int n;cin>>n;
	int before = -1 , length =0 , max= -1;
	while(n){
		int temp ; cin >> temp;
		if( before <= temp){
			length++;
		}
		else {
			length =1;
		}
		if (length > max) max = length;
		before = temp;
		n--;
	}
	cout << max;
	return 0;
}
