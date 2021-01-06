#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl= '\n';
const int LOG = 16, MM = 5e4+3;
int b[LOG][MM], a[LOG][MM];
int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    int n,q; cin >> n >> q;
    for (int i = 0; i < n; i++) {int x;cin>>x;b[0][i] = a[0][i] = x;}
    for (int k = 1; k < LOG; k++) {
        for (int i = 0; i + (1<<k) <= n; i++) {
            a[k][i] = max(a[k-1][i],a[k-1][i+(1<<(k-1))]);b[k][i] = min(b[k-1][i],b[k-1][i+(1<<(k-1))]);
        }
    }
    while(q--) {
        int x,y; cin >> x >> y;
        x--,y--;
        int k = 31-__builtin_clz(y-x+1); 
        cout << max(a[k][x],a[k][y-(1<<k)+1]) -min(b[k][x],b[k][y-(1<<k)+1]) << nl;
    }
}