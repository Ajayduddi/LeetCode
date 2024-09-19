// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

var findMaxLength = function (nums) {
    let sum = 0;
    let maxLength = 0;
    let map = {};
    map[0] = -1;

    for (let [index, i] of nums.entries()) {
        sum += (i == 1) ? 1 : -1;

        if (sum in map) {
            let length = index - map[sum];
            maxLength = Math.max(maxLength, length);
        } else {
            map[sum] = index;
        }
    }

    return maxLength;
};

console.log(findMaxLength([1, 1, 0, 0]))

/*
 * calculate the sum as follows. if you find a 1 add 1 to the sum; if you find 0 substract 1 from the sum.
 * nums = [1,1,0,0,1,1,0,1,1]
 * sum = [1,2,1,0,1,2,1,2,3]
 * Observe it carefully. If you find a sum which you have already found. you actually have a subarr with equal number of 0's and 1's. 
 * For example. in the sum array you have 2 as the sum in index 1. you found the sum 2 again in index 5. 
 * see the elements of nums from index 2 to 5 you have equal number of 0's and 1's. 
 * Write that down in a paper and pen and you can observe it easily.
 * One more edge case is , what if you have a sum as 0.
*/