#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;
const int MAXN=1005;
int n,m;
int f[MAXN];  /* f[j]: 前i个物品放入体积为j的背包中，能够获得的最大收益 */
int v[MAXN],w[MAXN];

/* 01 背包问题：降维优化*/
int main(){
    cin >> n >> m;
    for(int i=1;i<=n;i++) cin >> v[i] >> w[i];
    for(int i=1;i<=n;i++)
        for(int j=m;j>=v[i];j--) f[j]=max(f[j],f[j-v[i]] + w[i]);
    cout << f[m] << endl;
    return 0;
}