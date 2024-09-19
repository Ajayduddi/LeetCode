/* Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 */

var wordPattern = function (pattern, s) {
    let strarr = s.split(" ");
    let hashtable = {};
    let ans;
    if (pattern.length > 0 && pattern.length <= 300 && pattern === pattern.toLowerCase()) {
        for (let [index, data] of strarr.entries()) {
            if (pattern[index] in hashtable) {
                if (hashtable[pattern[index]] === data) {
                    ans = true;
                }
                else {
                    return false
                }
            }
            else {
                for (let value of Object.values(hashtable)) {
                    if (value === data) {
                        return false
                    }
                }
                hashtable[pattern[index]] = data;
                    if (strarr.length === pattern.length) {
                        ans = true;
                    } else {
                        return false;
                    }
            }
        }
    }
    else {
        return false
    }

    return ans;
};

console.log(wordPattern("abc", "dog cat ape"));