#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
long long N , M , mid, cut_sum, ans;
vector <long long> wood;
void input() {
	cin >> N >> M ;
	for (int index = 0; index < N; index++) {
		long long t; cin >> t;
		wood.push_back(t);
	}
}

long long cut(vector< long long> wood, int mid) {
	long long sum = 0;
	for (auto wood_one : wood) {
		if (wood_one > mid) {
			sum += (wood_one - mid);
		}
	}
	return sum;
}

int main(void) {
	input();

	long long left = 0;
	long long right = *max_element(wood.begin(), wood.end());

	while (left <= right) {

		mid = (left + right) / 2;
		cut_sum = cut(wood, mid);
		
		if (cut_sum < M) {
			right = mid - 1;
		}
		else {
			if (ans < mid) ans = mid;
			left = mid + 1;
			
		}

		if (cut_sum == M) break;
	}
	cout << ans;
	return 0;
}