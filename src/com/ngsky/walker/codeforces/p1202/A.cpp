#include<cstdio>
#include<cstring>
using namespace std;

const int MAXN=1e5+50;
char A[MAXN], B[MAXN];

int main(){
//     freopen("in.txt", "r", stdin);
    int T=0;scanf("%d", &T);
    for(int _=0;_<T;_++){
       scanf("%s%s", A, B);
       int la=strlen(A), lb=strlen(B);
       int ca=1,cb=1;
       while(B[lb-cb]=='0') ++cb;
       if(cb>la) {printf("0\n"); continue;}
       ca=cb;
       while(A[la-ca]=='0') ++ca;
       printf("%d\n",ca-cb);     
    }    
    return 0;
}