#include <iostream>
#include <vector>
using namespace std;



int solution(int n)
{
	int ans = 0;
	for (int M = n; M >= 1;) {
		if (M == 0) break;
		if (M % 2 == 0) {
			M = M / 2;
		}
		else {
			M = M - 1;
			ans++;
		}
	}

	return ans;
}
int main(void) {
	cout << solution(5);
	cout << solution(6);
	cout << solution(5000);
}