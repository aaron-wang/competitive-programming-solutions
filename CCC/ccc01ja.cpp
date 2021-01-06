#include <bits/stdc++.h>

using namespace std;

int main() {
    int m,x;

    scanf("%d", &x);
    scanf("%d", &m);

    int n = -1;

    for (int i = 1; i < m; i++) {
        // int current = x * i;
        if (x * i % m == 1) {
            n = i;
            break;
        }
    }
    if (n == -1) {
        printf("No such integer exists.\n");
    }
    else {
        printf("%d",n);
    }
}