#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl = '\n';
const int MM = 2e5+5;
struct node {
    int l,r;
    ll sum, lz;
} seg[3*MM];
int n,MOD,q, a[MM];
void pushup(int rt) {
    seg[rt].sum = (seg[rt<<1].sum + seg[rt<<1|1].sum)%MOD;
}
void pushdown(int rt) {
    int l = rt<<1, r = rt<<1|1;
    seg[l].lz += seg[rt].lz;
    seg[r].lz += seg[rt].lz;
    seg[l].sum = (seg[l].sum + (seg[l].r - seg[l].l + 1) * seg[rt].lz) %MOD;
    seg[r].sum = (seg[r].sum + (seg[r].r - seg[r].l + 1) * seg[rt].lz) %MOD;
    seg[rt].lz = 0;
}
void build(int l, int r, int rt) {
    seg[rt].l = l, seg[rt].r = r;
    if (l==r) {
        seg[rt].sum = a[l];
        // cin >> seg[rt].sum;
        return;
    }
    int mid = l+(r-l)/2;
    build(l,mid,rt<<1); build(mid+1,r,rt<<1|1);
    pushup(rt);
}
void rangeup(int l, int r, int v, int rt) {
    if (seg[rt].l == l && seg[rt].r == r) {
        seg[rt].lz += v;
        seg[rt].sum = (seg[rt].sum + (ll)(r-l+1) * v)%MOD;
        return;
    }
    if (seg[rt].lz) pushdown(rt);
    int mid = (seg[rt].l + seg[rt].r)/2;
    if (r <= mid) rangeup(l,r,v,rt<<1);
    else if (l > mid) rangeup(l,r,v,rt<<1|1);
    else {
        rangeup(l,mid,v,rt<<1);
        rangeup(mid+1,r,v,rt<<1|1);
    }
    pushup(rt);
}
ll query(int l, int r, int rt) {
    if (seg[rt].l == l && seg[rt].r == r) {
        return seg[rt].sum;
    }
    if (seg[rt].lz) pushdown(rt);
    int mid = (seg[rt].l + seg[rt].r)/2;
    if (r <= mid) return query(l,r,rt<<1);
    else if (l > mid) return query(l,r,rt<<1|1);
    else return (query(l,mid,rt<<1) + query(mid+1,r,rt<<1|1))%MOD;
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    cin >> MOD >> n >> q;
    for (int i = 1; i <= n; i++) cin >> a[i];
    build(1,n,1);
    while (q--) {
        int op,l,r; cin >> op >> l >> r;
        if (op == 1) {
            int x;
            cin >> x; rangeup(l,r,x,1);
        }
        else {
            cout << query(l,r,1)%MOD << nl;
        }
    }

}