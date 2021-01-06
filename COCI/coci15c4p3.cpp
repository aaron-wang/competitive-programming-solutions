 #include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';using vi=vector<int>;
const int MM = 1e3+5;
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int n; cin >> n; vector<int> ans(n,0);
    for (int i = 0; i < n; i++) {
        for (int j = 0,x; j <n; j++) {
            cin >> x;ans[i] |=x;
        }
    }
    // reduced number for each cell, bitwise or all of them 
    //to see at least what ai was
    // 100, 010 --> 110
    for (auto x: ans) {
        cout << x << " ";
    }cout<< nl;

}