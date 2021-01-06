#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';
int c[4], ans;
void check(int v) {
    if (v > 24 || v < 0) return;
    ans = max(ans,v);
}
void f(int cur, int k, int x) {
    if (x == 3) {
        //end of cards
        check(cur+k); check(cur-k); check(cur*k);
        if (k && cur%k==0) check(cur/k);
        return;
    }
    //normal ordering
    f(cur+k,c[x+1],x+1); f(cur-k,c[x+1],x+1);
    f(cur*k,c[x+1],x+1);
    if (k && cur%k==0) {
        f(cur/k,c[x+1],x+1);
    }
    //do the other one first
    f(cur,k+c[x+1],x+1); f(cur,k-c[x+1],x+1);
    f(cur,k*c[x+1],x+1);
    if (c[x+1] && k%c[x+1]==0) {
        f(cur,k/c[x+1],x+1);
    }
}
int main() {
    cin.sync_with_stdio(0); cin.tie(0);
    ans = 0;
    int t; cin >> t;
    while (t--) {
        ans = 0;
        for (int i = 0; i < 4; i++) cin >> c[i]; 
        sort(c,c+4);
        do {
            f(c[0],c[1],1);
        } while (next_permutation(c,c+4));
        cout << ans << nl;
    }
}