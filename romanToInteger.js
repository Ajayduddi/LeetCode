/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    let hashMap = { 
        "I":1,
        "V":5,
        "X":10,
        "L":50,
        "C":100,
        "D":500,
        "M":1000,
    };

    let arr = ["I","V","X","L","C","D","M"];
    let num = 0, i = 0;

    while(i<s.length){
        if( arr.indexOf(s.charAt(i)) >= arr.indexOf(s.charAt(i+1)) ){
            num += hashMap[s.charAt(i)];
        }
        else{
            num -= hashMap[s.charAt(i)];
        }
        i++;
    }
};

console.log(romanToInt("LVIII"));