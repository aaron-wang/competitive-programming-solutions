 #include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl = '\n';
int no[30];
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int n,m; cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int a,b; cin >> a >> b;a--,b--;
        no[a] |= (1<<b); no[b] |= (1<<a);
    }
    int cnt = 0;
    for (int m = 0; m<1<<n; m++) {
        bool yes = true;
        for (int i =0 ; i < n; i++) {
            //bad intersects with current group.
            //bad of 2 = 0001000
            //mask is..= 0011010
            if (m&(1<<i) && (m&no[i])) {
                yes = false;
                break;
            }
        }
        if (yes) cnt++;
    }cout << cnt<< nl;
}