var findComplement = function (num) {
    let b = num.toString(2);
    let arr = b.split("");

    for (let [index,i] of arr.entries()) {
        if (i == 0) {
            arr[index] = 1;
        }
        else {
            arr[index] = 0;
        }
    }

    b = arr.join("");
    return parseInt(b, 2);
};

console.log(findComplement(10))

// finding complement of a number in binary form