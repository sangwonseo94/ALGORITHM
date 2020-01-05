#include <iostream>

using namespace std;
const int mod = 1000000000;
int main(void){
	int n ; cin >> n;
	int cache[101][10]={};
	for (int index= 0 ; index <10 ; index++){
		cache[1][index] = 1; 
	}
	
	for( int i = 2 ; i <=n ; i++){
		for(int j = 0 ; j < 10 ; j ++){
			if( j == 0 ){
				cache[i][j] = cache[i-1][j+1] % mod;
			}
			else if(j == 9){
				cache[i][j] = cache[i-1][j-1] % mod;
			}
			else{
				cache[i][j] = (cache[i-1][j-1] + cache[i-1][j+1]) % mod;
			}
		}
	}
	
	int sum = 0;
	for(int index=1 ; index < 10; index++){
		sum =( (sum +cache[n][index]) % mod );
	}
	cout << sum;
	return 0;
}
