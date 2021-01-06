#include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n';

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int N;
    cin >> N;
    char s[N];
    for (int i = 0; i < N; i++) {
        cin >> s[i];
    }
    int ans = 0;
    for (int i = 0; i < N; i++) {
        char here = s[i],temp;
        cin >> temp;
        if (here == temp) {
            ans++;
        }
    }
    cout << ans << nl;
}