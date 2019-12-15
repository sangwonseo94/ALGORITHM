#include <iostream>
#include <algorithm>
using namespace std;
int N, num[100001], dp[100001] , mini = -1001;
bool ALL_MINUS = true;
void input() {
	cin >> N;
	for (int i = 1; i <= N; i++) {
			cin >> num[i];
			
			if (num[i] >= 0) {
				ALL_MINUS = false;
			}
			if (mini < num[i]) {
				mini = num[i];
			}
	}
}


int main() {
	int ans;
	input();
	if (ALL_MINUS) {
		cout << mini;
		
	}
	else{
	dp[1] = num[1];
	ans = dp[1];
	for (int index = 2; index <= N; index++) {


		if (dp[index - 1] < 0) {
			dp[index] = num[index];
			if (ans < dp[index]) ans = dp[index];
		}
		else {
			dp[index] = dp[index - 1] + num[index];
			if (ans < dp[index]) ans = dp[index];
		}

	}
	cout << ans;
	}
}