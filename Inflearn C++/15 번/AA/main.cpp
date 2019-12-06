#include <iostream>
#include <cmath>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	int N,cnt = 0; cin>> N;
	for(int i = 2 ; i <= N ; i++) {
		bool Prime = true;
		for(int j = 2 ; j <=sqrt(i) ; j ++){
			if(i%j ==0){
				Prime = false;
				break;
			}
		}
		if(Prime) cnt++;
	}
	cout <<  cnt;
	return 0;
}
