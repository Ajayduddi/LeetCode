// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.


var twoSum = function (nums, target) {
    let arr = {};
    for (let [x,num] of nums.entries()) {
        let diff = target - num;
        if (diff in arr) {
            return [arr[diff], x];
        }
        else {
            arr[num] = x
        }
    }
};

console.log(twoSum([-3, 4, 3, 90],0));