#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

// 切钢条
// 动态规划：自底向上
// 时间复杂度： O(n)
int main(){
    int p[]={0,1,5,8,9,10,17,17,20,24,30};
    int n=4;
    // dp[i]: 钢条长度为i时，切割最大收益
    int dp[n+1];
    // 初始化
    dp[0]=0;
    for(int i=1;i<=n;i++){
        int q=-1;
        for(int j=1;j<=i;j++){
            q=max(q,p[j]+dp[i-j]);
        }
        dp[i]=q;
    }
    cout << dp[n] << endl;
    return 0;
}