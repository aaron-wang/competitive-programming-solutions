#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl= '\n';
bool solve() {
    stack<int> m, b;
    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        int x; cin >> x;m.push(x);
    }
    int k = 1;
    while (k <= n) {
        if (!m.empty() && m.top() == k) {
            m.pop();k++;
        }
        if (!b.empty() && b.top() == k) {
            b.pop(); k++;
        }
        else if (!m.empty()) {
            b.push(m.top());m.pop();
        }
        else {
            return false;
        }
    }return true;
}
int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    int t;cin >> t;
    while(t--) {
        cout << (solve() ? "Y" :"N") << nl;
    }
}