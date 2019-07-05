#include <iostream>
#include <vector>
using namespace std;
vector<long long> dp(91,0);

long long fibonacci(long long x){
	if(x==0)return dp[0];
	if(x==1)return dp[1];
	if(dp[x]==0) dp[x] =fibonacci(x-1)+fibonacci(x-2);
	return dp[x];
}

int main(void) {
	dp[0]=0;dp[1]=1;
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);cout.tie(NULL);
	long long x;
	cin >> x;
	cout << fibonacci(x) <<'\n';
}