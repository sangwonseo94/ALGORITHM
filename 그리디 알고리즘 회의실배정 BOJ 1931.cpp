#include <iostream>
#include <vector>
#include <string>
#include <stack>
#include <deque>
#include <set>
#include <queue>
#include <algorithm>

using namespace std;

int main(void) {
	cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(NULL);
	int N; cin >> N;
	int start =INFINITY, end = -1;
	vector< pair<int, int>> timetable;
	for (int arr = 0; arr < N; arr++) {
		int n, m; cin >> n >> m;
		if (start > n) start = n;
		if (end < m) end = m;
		timetable.push_back({ n,m });
	}



}
 