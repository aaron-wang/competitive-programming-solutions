#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MM = 1e6+3;
int m[MM], tree[MM];
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int N, Q;
    cin >> N;
    for (int i = 1; i <= N; i++) {
        cin >> m[i];
        tree[i] = tree[i-1] + m[i];
    }
    cin >> Q;
    for (int i = 0; i < Q; i++) {
        int a,b;
        cin >> a >> b;
        a++,b++;
        cout << tree[b] - tree[a-1] << endl;
    }
}