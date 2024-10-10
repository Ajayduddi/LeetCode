// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
// The order of the elements may be changed.Then return the number of elements in nums which are not equal to val.

var removeElement = function (nums, val) {
    let i = 0;
    while (i < nums.length) {
        if (nums[i] === val) {
            nums.splice(i, 1);
        } else { 
            i++;
        }
    }

    return nums;

    // both are same
    // let arr = nums.filter(item => item != val);
    // return arr;
};

console.log(removeElement([0,1,2,2,3,0,4,2], 2));