#include <iostream>
#include <vector>
using namespace std;
vector<int> dp(1000000,0);
int make_one(int x){
	if(x==1) return dp[1];
	if(x==2) return dp[2];
	if(x==3) return dp[3];
	if(dp[x]!=0) return dp[x];
	if( x%3 !=0 && x%2 !=0) return dp[x] = dp[x-1] + 1;
	if( x%2 !=0 && x%3 ==0) return dp[x] = min(dp[x%3]+1,dp[x-1]+1);
	if( x%2 ==0 && x%3 !=0)	return dp[x] = min(dp[x%2]+1,dp[x-1]+1);
	if( x%2 ==0 && x%3 ==0)	return dp[x] = min(dp[x%2]+1,dp[x%3],dp[x-1]+1);
}
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	dp[1] = 0; dp[2] = 1; dp[3] = 1; 
	int number;
	cin >> number;
	cout << make_one(number);
}