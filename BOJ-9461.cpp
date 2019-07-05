#include <iostream>
#include <vector>
using namespace std;
vector<unsigned long long> dp(100,0);

unsigned long long badak(unsigned long long x){
	if(x==1) return dp[1];
	if(x==2) return dp[2];
	if(x==3) return dp[3];
	if(x==4) return dp[4];
	if(x==5) return dp[5];
	if(dp[x]!=0) return dp[x];
	else return dp[x] = (badak(x-1) + badak(x-5))  ; 
 
}
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	dp[1] = 1;dp[2] = 1;dp[3] = 1;
	dp[4] = 2;dp[5] = 2;
	vector<int> input;
	int number,result,testcase;
	cin >> testcase  ;
	while(testcase){
		unsigned long long temp; cin >> temp;
	input.push_back(temp);
	testcase--;}
	for(auto arr: input) {
		cout << badak(arr) <<'\n';
	}
}