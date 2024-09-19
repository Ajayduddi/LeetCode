var repeatedSubstringPattern = function (s) {
    let ans;
    let str = s.concat(s).split("");
    str.shift(0, -1);
    str.pop();
    if (str.join("").includes(s)) {
        ans = true;
    }
    else {
        return false
    }

    return ans;
};

console.log(repeatedSubstringPattern("aba"));