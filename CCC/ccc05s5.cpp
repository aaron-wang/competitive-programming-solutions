#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using pi = pair<int,int>;
using ll = long long; constexpr char nl = '\n';
const int MM = 1e5+3;
int tr[MM],a[MM], rk[MM];
pi p[MM];
void update(int x, int val) {
    for (int i =x;i < MM; i+=i&-i) tr[i]+=val;
}
int query(int x) {
    int ret = 0;
    for (int i = x; i > 0; i-=i&-i) ret += tr[i];
    return ret;
}
int main() {
    // cin.sync_with_stdio(false); cin.tie(0);
    int T; scanf("%d",&T);
    for (int i = 1; i <= T; i++) {
        // cin >> a[i];
        scanf("%d",a+i);
        p[i] = {a[i],i};
    }
    sort(p+1,p+1+T);
    for (int i = 1; i <= T; i++) {
        rk[p[i].second] = i;
    }
    double ans = 0;
    for (int i = 1; i <= T; i++) {
        update(rk[i],1);
        ans += i - query(rk[i]-1);
    }
    printf("%.2f\n",ans/(double)T);
    
}