#include <iostream>
#include <bits/stdc++.h>

using namespace std;

// Nodes for the trie
struct TrieNode {
    // Count to keep track how many strings are 
    // ending at the current node in the trie.
    int count_at_temination;

    // A Trie node should have 26 other nodes
    // as it is for the 26 smallcase letters.
    // Therefore, using a map.
    map<int, TrieNode*>* trieNodes;

    // Checking for the particular character
    // If exists return the next path from it.
    TrieNode* next(char c) {
        // If the char c does not exist, it return NULL
        // Otherwise the character which is after this char c.
        int key = int(c)-int('a');
        if ((*trieNodes).find(key) == (*trieNodes).end()) {
            // It means the value does not exist.
            return NULL;
        } else {
            // Else return the value which is at the key.
            return (*trieNodes).at(key);
        }
    }
};

// Function to query for a string in the trie
int query(TrieNode* root, string s) {
    TrieNode* current_node = root->next(s.at(0));
    int str_length = s.length();
    for (int i = 1; i < str_length; ++i) {
        if (current_node == NULL) {
            cout << "The string you are querying for does not exists.\n";
            return 0;
        }
        current_node = current_node->next(s.at(i));
    }
    return current_node->count_at_temination;
}

// Function to insert the string in the trie
void insertString(TrieNode* root, string s) {
    TrieNode* current_node = root->next(s.at(0));
    for (int i = 1; i < s.length(); ++i) {
        if (current_node == NULL) {
            pair<int, TrieNode*> p = pair<int, TrieNode*>(int(s[i]-'a'), NULL);
            current_node->trieNodes->insert(p);
        }
        current_node = current_node->next(s.at(i));
    }
    current_node->count_at_temination += 1;
}   

// Function to delete the string from the trie
void deleteString(TrieNode* root, string s) {
    TrieNode* current_node = root->next(s.at(0));
    int str_length = s.length();
    for (int i = 1; i < str_length; ++i) {
        if (current_node == NULL) {
            cout << "The string does not exists.\n";
            return ;
        }
        current_node = current_node->next(s.at(i));
    }
    current_node->count_at_temination -= 1;
}

// Function to update the string
void updateString(TrieNode* root, string oldString, string updatedString) {
    deleteString(root, oldString);
    insertString(root, updatedString);
}

// main function 
int main() {
    // Initialising the root of the trie
    TrieNode* trie_root = new TrieNode{};

    string string_array[5] {"pqrs", "pprt", "psst", "qqrs", "pqrs"};

    for (int i = 0; i < 5; ++i) {
        insertString(trie_root, string_array[i]);
    }

    // for (int i = 0; i < 5; ++i) {
    //     cout << string_array[i] << " : " << query(trie_root, string_array[i]);
    // }

    return 0;
}