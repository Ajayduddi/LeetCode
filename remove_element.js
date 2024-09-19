// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
// The order of the elements may be changed.Then return the number of elements in nums which are not equal to val.

var removeElement = function (nums, val) {
    let arr = []
    for (let [index,item] of nums.entries()) {
        if (item == val) {
            arr.push(item);
        }
    }

    for (let i of arr) {
        nums.splice(nums.indexOf(i), 1);
    }

    return nums;

    // both are same
    // let arr = nums.filter(item => item != val);
    // return arr;
};

console.log(removeElement([0, 1, 3, 0, 4, 2], 2));