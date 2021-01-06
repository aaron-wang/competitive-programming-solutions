#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using pi = pair<int,int>; using vi = vector<int>;
using ll = long long; constexpr char nl = '\n';
const int MM = 5e4+2;
int N,K;
int a[MM], b[MM], dp[MM], rk[MM];
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    cin >> N >> K;
    //N is divisible by K
    for (int i = 0; i < N; i++) {
        cin >> a[i]; b[i] = a[i];
    }
    sort(b,b+N);
    for(int i = 0; i < N; i++) {
        rk[i] = (lower_bound(b,b+N,a[i]) - b)/K;
    }
    int inorder = 0;
    //9 1 1 7 2 3 8 4 5
    //^ ^ ^ X ^ ^ X ^ ^
    //remove most "out of order" elements
    //by finding the most in order ones
    for (int i = 0; i < N; i++) {
        dp[i] = 1;
        //N = 5000, so ok
        //regular LIS (nonstrict)
        for (int j = 0; j < i; j++) {
            if (rk[i] >= rk[j]) {
                dp[i] = max(dp[i],dp[j]+1);
            }
        }
    }
    for (int i = 0; i < N; i++) {
        inorder = max(inorder,dp[i]);
    }
    cout << N - inorder;
}