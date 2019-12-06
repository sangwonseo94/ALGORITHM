#include <iostream>
#include <cmath>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int reverse ( int temp){
	int res , cnt = 0; 
	while(temp>0){
		cnt  = temp %10;
		res = res*10 + cnt;
		temp /=10;
	}
	
	return res;
}


bool isPrime(int temp){
	if( temp == 1) return false;
	for (int i =2; i <(temp) ; i++ ){
		if(temp % i == 0) return false;
	}
	return true;
}

int main(int argc, char** argv) {
	int N; cin >> N;
	while(N){
		int temp; cin>>temp;
		temp = reverse(temp);
		if(isPrime(temp)){
			cout<<temp;
		}
		N--;
	}
	return 0;
}
