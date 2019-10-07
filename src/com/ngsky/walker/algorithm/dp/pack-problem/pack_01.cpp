#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int MAXN = 1005;
int n,m;
int f[MAXN][MAXN]; /* f[i][j]:前i个物品放入容量为j的背包中，所能获得的最大收益 */
int v[MAXN],w[MAXN];
/* 01 背包问题：简单解法*/
int main(){
    cin >> n >> m;
    for(int i = 1;i<=n;i++) cin >> v[i] >> w[i];
    for(int i = 1;i<=n;i++)
        for(int j=0;j<=m;j++){
            if(j < v[i]) f[i][j] = f[i-1][j];
            else f[i][j] = max(f[i-1][j],f[i-1][j-v[i]] + w[i]);
        }
    int res = 0;
    for(int i=0;i<=m;i++) res=max(res,f[n][i]);
    cout << res << endl;
    return 0;
}