#include <algorithm>
#include <cmath>
#include <climits>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <string>
#include <vector>

using namespace std;

struct trieNode {
    int count = 0;
    map<char, trieNode *> *next;

    trieNode(int c, map<char, trieNode *> *n) {
        count = c;
        next = n;
    }
};

void insert(trieNode *t, const string &str) {
    for (char c: str) {
        if (t->next->find(c) == t->next->end()) {
            pair<char, trieNode *> p = pair<char, trieNode *>(c, new trieNode(0, new map<char, trieNode *>()));
            t->next->insert(p);
        }
        t = t->next->at(c);
    }
    t->count++;
}

int findFreq(trieNode *t, const string &str) {
    bool found = true;

    for (char c: str) {
        if (t->next->find(c) == t->next->end()) {
            found = false;
            break;
        }
        t = t->next->at(c);
    }

    return found ? t->count : 0;
}

int main() {
    trieNode *trieRoot = new trieNode{
            0,
            new map<char, trieNode *>()
    };

    int N = 5;
    string strs[] = {"ab", "abc", "ab", "abcd", "abcde"};

    for (int i = 0; i < N; ++i) {
        insert(trieRoot, strs[i]);
    }

    for (int i = 0; i < N; ++i) {
        cout << strs[i] << " came " << findFreq(trieRoot, strs[i]) << " times\n";
    }

    return 0;
}