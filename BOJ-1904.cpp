#include <iostream>
#include <vector>
using namespace std;
vector<int> dp(1000000,0);
 
int badak(int x){
	if(x==1) return dp[1];
	if(x==2) return dp[2];
	if(dp[x]!=0) return dp[x];
	else return dp[x] = (badak(x-1) + badak(x-2))%15746  ; 
 
}
int main(void) {
		ios_base::sync_with_stdio(false);
		cin.tie(NULL); cout.tie(NULL);
	dp[1] = 1;
	dp[2] = 2;
 
 
	int number,result;
	cin >> number ;
	result = badak(number);
	cout << result %15746 <<"\n";
}