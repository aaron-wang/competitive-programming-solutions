#include <bits/stdc++.h>
using namespace std;
using ll = long long; constexpr char nl = '\n';
int main() {
    cin.sync_with_stdio(0);cin.tie(0);
    int n; cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    sort(a.begin(),a.end());
    int l = n/2, r = n/2;
    if (n&1) r++;
    else l--;
    for (int i = 0 ; i < n/2; i++) {
        cout << a[l] << " " << a[r] << " ";
        l--, r++;
    }
    if (n&1) cout << a[l] << " ";
}