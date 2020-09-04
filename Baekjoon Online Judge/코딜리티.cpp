#include <algorithm>
#include <stack>
#include <string>
#include <vector>
#include <iostream> 
using namespace std;

vector < int > binary_num ;
int ans= -1, res = 0;
void bin (int N){
    
    if ( N != 1 ) bin ( N/2);
    binary_num.push_back(N%2);
}

int solution(int N) {
    bin(N);
    for (int index = 0 ; index < binary_num.size() ; index++){
    	if( binary_num[index] == 0 ) res++;
    	else {
    		if( ans < res) ans = res;
    		res = 0;
		}
	}
    return ans;
}

int main(void){
	cout << solution(9) << endl;
	///cout << solution(529) << endl;
	///cout << solution(20) << endl;
	///cout << solution(15) << endl;
	///cout << solution(32) << endl;
	///cout << solution(1041) << endl;
	return 0;
}
