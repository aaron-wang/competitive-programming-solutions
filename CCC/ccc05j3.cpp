#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    vector<string> places;
    vector<char> dir;

    string current = "";

    while (current != "SCHOOL") {
        char d;
        string s = "";
        cin >> d;
        cin >> s;

        current = s;

        places.push_back(s);
        dir.push_back(d);
    }
    cin.ignore();
    
    for (int i = places.size() - 1; i >= 0; i--) {
        // printf("%d",i);
        // printf("%d",j);
        const char *com;
        if (dir[i] == 'R') {
            current = "LEFT";
            // com = current.c_str();
        }
        else {
            current = "RIGHT";
            // com = current.c_str();
        }

        if (i != 0) {
            // printf("Turn %s onto %s street.\n",current,places[i]);
            printf("Turn %s onto %s street.\n",current.c_str(),places[i - 1].c_str());
        }
        else {
            printf("Turn %s into your HOME.\n",current.c_str());
        }
    }
}