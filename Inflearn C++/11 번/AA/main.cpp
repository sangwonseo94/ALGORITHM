#include <iostream>
#include <cmath>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int main(int argc, char** argv) {
	
	int n;
	cin >>n;
	int sum=0,c=1,d=9,res=0;
	while(sum+d<n){
		res += (c*d);
		sum +=d;
		d *= 10;
		c +=1;
	}
	
	res += c*(n-sum);
	cout <<res;
	
	return 0;
}
