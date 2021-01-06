#include <bits/stdc++.h>

using namespace std;

int main() {
    int start, end;
    scanf("%d",&start);
    scanf("%d",&end);

    int count = 0;

    for (int i = start; i <= end; i++) {
        // cout << i << "\n";
        string num = to_string(i);
        // cout << num[0] << "\n";
        bool is_like = true;
        //even
        // if (num.length() % 2 == 0) {
        if (i > 9) {
            for (int j = 0; j < num.length()/2; j++) {
                string top, bot;
                top = num[j];
                bot = num[num.length() - j - 1];
                if (top != bot) {
                    if ((top == "6" && bot == "9") || (top == "9" && bot == "6")) {
                        //
                    }
                    else {
                        is_like = false;
                        break;
                    }
                }
                else {
                    if (top == "8" || top == "1" || top == "0") {

                    }
                    else {
                        is_like = false;
                        break;
                    }
                }
            }
            if (num.length() % 2 != 0) {
                string wow;
                wow = num[num.length()/2];
                if (wow == "8" || wow == "0" || wow == "1") {
                    
                }
                else {
                    is_like = false;
                }
            }
        }
        else {
            if (num != "8" && num != "0" && num != "1") {
                is_like = false;
            }
        }
        
        
        // }
        //odd
        // else {

        // }

        if (is_like) {
            // cout << "true for " << i << "\n";
            count++;
        }
    }
    cout << count;
}