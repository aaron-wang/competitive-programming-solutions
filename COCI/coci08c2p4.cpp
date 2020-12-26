 #include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';
const int MM = 105;
pair<int,int> a[MM],b[MM];
int n,m;
ll gett(int s) {
    ll ret= 0;
    for (int i = 1; i <= n; i++) {
        int x = s-a[i].first;
        if (x>= 0) {
            ret++;
            ret += x/a[i].second;
        }
    } return ret;
}
int brk(int s) {
    ll ret = 0;
    for (int i = 1;i<=m; i++) {
        int x = s-b[i].first;
        if (x>=0) {
            ret++;
            ret += x/b[i].second;
        }
    }return ret;
}
int main() {
    cin.sync_with_stdio(0); cin.tie(0);
    //N for get coconut: M for open coconut
    //for monkey i, initial A, then B per coconut
    //for monkey i, initial C, then D per coconut
    //know time, don't know coconuts
    //find out when zookeepers come in between
    // 1 -- k -- 2
    //f(x) calc 1, g(x) calc 2
    ll t; cin >> t;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        int x,y; cin >> x >> y;
        a[i] = {x,y};
    }
    cin >> m;
    for (int i = 1; i <= m; i++) {
        int x,y; cin >> x>>y;
        b[i] = {x,y};
    }
    // cout << f(t);
    //total coconut off == total coconut break
    int l = 0, r = t,ans=-1;
    while (l <= r) {
        int m = l+(r-l)/2;
        if (gett(m) > brk(t-m)) {
            r=m-1;
        }
        else {
            ans = m;
            l=m+1;
        }
    }
    cout << ans << nl;
}