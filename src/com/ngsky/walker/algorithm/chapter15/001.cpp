#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

// 15.1 切钢条问题
// 递归法求解: 时间复杂度T(n)=2^n
int cut_rod(int p[],int n){
    if(n==0) return 0;
    int q=-1;
    for(int i=1;i<=n;i++){
        // q:不切断
        // p[i]+cur_rod(p,n-1): 前长度为i的小棒不变，后n-i继续切断
        q=max(q, p[i]+cut_rod(p,n-i));
    }
    return q;
}

int main(){
    int p[]={0,1,5,8,9,10,17,17,20,24,30};
    int n=4;
    int res=cut_rod(p,n);
    cout << res << endl;
    return 0;
}