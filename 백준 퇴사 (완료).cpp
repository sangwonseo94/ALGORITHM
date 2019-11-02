#include <iostream>

using namespace std;

int N[1001] = { 0, };
int P[1001] = { 0, };
int max_v = 0;
int n;
void timetable(int day, int profit) {
	if (day == n + 1) {
		if (profit > max_v) max_v = profit;
		return;
	}
	if (day > n + 1)return;

	timetable(day + N[day], profit + P[day]);
	timetable(day + 1, profit);

}

int main(void) {
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> N[i] >> P[i];
	}
	timetable(1, 0);
	cout << max_v;

}