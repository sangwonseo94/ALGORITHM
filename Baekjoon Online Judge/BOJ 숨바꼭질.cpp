#include <iostream>
#include <queue>
using namespace std;
int N, K, time;
bool visit[100001];
typedef struct {
	int now, time;

}pos;
int main(void) {
	cin >> N >> K;
	if (K < N) {
		cout << N - K;
	}
	else if (N == K) {
		cout << 0;
	}
	else {

		pos start = { N , 0 };
		queue < pos > Q;
		Q.push(start);
		int now = N;
		while (!Q.empty()) {

			now = Q.front().now;
			time = Q.front().time;
			if (now == K) break;
			Q.pop();

			if (now + 1 <= 100000 && !visit[now + 1]) {
				visit[now + 1] = true;
				Q.push({ now + 1 , time + 1 });
			}
			if (2 * now <= 100000 && !visit[2 * now]) {

				visit[2 * now] = true;
				Q.push({ 2 * now , time + 1 });
			}
			if (now - 1 >= 0 && !visit[now - 1]) {
				visit[now - 1] = true;
				Q.push({ now - 1 , time + 1 });

			}

		}
		cout << time;




	}


	return 0;
}