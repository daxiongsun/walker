#include <iostream>
#include <cstring>
#include <cmath>

using namespace std;

int main(){
    int n,k;
    int res=0;
    cin >> n >> k;
    for(int i=0;i<n;i++){
        int t;
        cin >>t;
        if(t>=k) res+=1;
    }
    cout << res << endl;
    return 0;
}