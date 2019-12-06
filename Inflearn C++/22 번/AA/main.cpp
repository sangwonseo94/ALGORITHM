#include <iostream>
#include <algorithm>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	int n,size; cin >> n >> size;
	int  max,res=0 , cnt = 0 , head, tail;
	int temper[n];
	if(size == 1 ){
		for( int index = 0; index < n ; index++){
			cin >> temper[index];
		}
		cout << *max_element(temper,temper+n);
	}
	else{
	
		for ( int index = 0; index < n ; index ++){
			
			cin >> temper[index];
			if(index == size) max= res;
			if(index < size){
				res +=temper[index];	
			}
			
			else {
				res -= temper[index-size];
				res += temper[index];
			
				if( res > max) max = res;	
					
			}
			
		}
		cout << max;
	}
	
	
	return 0;
}
