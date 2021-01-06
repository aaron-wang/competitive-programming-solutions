#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long;constexpr char nl = '\n';
const int MM = 1e4+5;
double dp[MM];
int a[MM], n;
// double solve(int x) {
//     if (x > n) return 0;
//     if (dp[x]) return dp[x];
//     double ret = a[x] + solve(x+1);
//     if (x+1 < n) {
//         if (x+2) {
//         }
//     }
// }
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    cin >> n;
    ll tot = 0;
    for (int i =1; i <= n; i++) {
        cin >> a[i];
        tot +=a[i];
    }
    //select contigous 2 or 3,
    //3 remove min, 2 remove 50% of min
    //what is the max you can remove.
    dp[0] = 0; //max removable
    for (int i = 1; i <= n; i++) {
        dp[i] = dp[i-1];
        if (i >= 2) {
            dp[i] = max(dp[i], dp[i-2] + (min(a[i-1],a[i]))/2.0);
        }
        if (i >= 3) {
            dp[i] = max(dp[i], dp[i-3] + min(a[i],min(a[i-1],a[i-2])));
        }
    }
    cout << fixed << setprecision(1) << tot - dp[n] << nl;
}