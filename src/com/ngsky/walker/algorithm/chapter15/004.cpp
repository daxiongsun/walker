#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

// 切钢条
// 自底向上动态规划
// 记录切割后，每段长度
int main(){
    int p[]={0,1,5,8,9,10,17,17,20,24,30};
    int n=4;
    int dp[n+1];
    int res[n+1];
    dp[0]=0;
    int q;
    for(int i=1;i<=n;i++){
        q=-1;
        for(int j=1;j<=i;j++){
            if(q<p[j]+dp[i-j]){
                q=p[j]+dp[i-j];
                res[i]=j;
            }
        }
        dp[i]=q;
    }
    cout << dp[n] << endl;
    while(n>0){
        cout << res[n] << " ";
        n=n-res[n];
    }
    cout << endl;
    return 0;
}