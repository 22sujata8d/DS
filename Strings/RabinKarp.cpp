#include<iostream>
#include<bits/stdc++.h>

using namespace std;

class RabinKarp {
private:

    string str, pattern;
    int mod = 1000000007;
    const int ALPHABET_SIZE = 26;

    // Returns the character code 
    int getCharCode(char ch) {
        int charCode = (ch - 'a' + 1);
        return charCode;
    }

    // Returns hash for pattern or original string
    int buildHash(string st) {
        int patternLength = pattern.length();
        int power = patternLength-1;
        int stHash = 0;

        for (int i = 0; i < patternLength; ++i) {
            stHash += (getCharCode(st[i]) * (int)pow(ALPHABET_SIZE, power) % mod);
            power -= 1;
        }

        return stHash;
    }

    // Returns the string hash code using rolling hash technique
    int rollingHashFunction(int strHash, string str, int index) {
        int patternLength = pattern.length();

        strHash -= (getCharCode(str[index-1]) * pow(ALPHABET_SIZE, patternLength-1));
        strHash = (strHash * ALPHABET_SIZE + getCharCode(str[index+patternLength-1]) % mod);

        return strHash;
    }

    // Checks if string hash code matches to pattern hash code
    bool isPatternFound(int strHash, int patternHash, int strIndex) {
        // Base Condition
        if (strHash != patternHash)
            return false;

        int patternLength = pattern.length();
        for (int i = 0; i < patternLength; ++i) {
            if (pattern[i] != str[strIndex])
                return false;
            strIndex += 1;
        }

        return true;
    }

public:
    // Constructor
    RabinKarp(string &s, string &p) : str(s), pattern(p) {};

    // Returns first index of pattern in string else returns -1
    // Using Rabin Karp Algorithm
    int rabinKarp() {
        int patternLength = pattern.length();
        int strLength = str.length();

        // Base Case
        if (strLength < patternLength)
            return -1;

        int patternHash = 0, strHash = 0;

        // Builds pattern hash code
        patternHash = buildHash(pattern);

        // Builds string hash code 
        strHash = buildHash(str);

        // Case: Pattern found in the string at the starting.
        if(isPatternFound(strHash, patternHash, 0))
            return 0;

        int index;
        // Check for other possible string hash codes
        // Case: When pattern can be found in string 
        for (index = 1; index < strLength - patternLength + 1; ++index) {
            if (isPatternFound(strHash, patternHash, index-1))
                return index-1;

            strHash = rollingHashFunction(strHash, str, index);
        }

        // Case: Pattern found in the string at the end
        if (isPatternFound(strHash, patternHash, index-1))
            return index-1;

        return -1;
    }
};


int main() {
    /****
        Find the starting index of the pattern in the string is found,
        otherwise output -1 as the final outcome.
    ****/

    string str, pattern;
    cout << "   --------------------------------------------------\n";
    cout << "   | All the user inputs should be in small letters |\n";
    cout << "   --------------------------------------------------\n\n"; 
    cout << "Enter the string in which pattern is to be found :\n";
    cin >> str;
    cout << "Enter the pattern :\n";
    cin >> pattern;
    
    RabinKarp* patternStringMatching = new RabinKarp(str, pattern);
    cout << "--------------Result---------------------" << endl;
    cout << patternStringMatching->rabinKarp() << endl;

    return 0;
}