#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

int main(){
    int d,n;
    cin >> d >> n;
    if(n==100) n+=1;
    for(int i=0;i<d;i++){
        n*=100;
    }
    cout << n << endl;
    return 0;
}