#include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n'; 
int M,F,R;
const int MM = 305, MN = 105;
int dp[MM][MN];
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int N;
    cin>>M>>F>>R;
    for (int i = 1; i <= R; i++) {
        int v,t,f;
        cin>>v>>t>>f;
        for (int j = M; j >= t; j--) {
            for (int k = F; k>= f; k--) {
                dp[j][k] = max(dp[j][k],dp[j-t][k-f] +v);
            }
        }
    }
    cout << dp[M][F] << nl;
}