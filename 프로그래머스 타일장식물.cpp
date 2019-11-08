#include <iostream>


using namespace std;

long long c[80] = { 0, };
bool v[80] = { false, };

long long fibo(long long N) {
	if (v[N]) return c[N];
	else {
		v[N] = true;
		return c[N] = fibo(N - 1) + fibo(N - 2);
	}
}
long long solution(int N) {
	long long answer = 0;
	if (N == 1) return 4;
	if (N == 2) return 6;
	if (N == 3) return 10;
	c[1] = 1; v[1] = true;
	c[2] = 1; v[2] = true;
	answer += (3 * fibo(N) + 2 * fibo(N - 1) + 2 * fibo(N - 2) + fibo(N - 3));
	return answer;
}
int main(void) {
	int N; cin >> N;
	cout << solution(N);

}