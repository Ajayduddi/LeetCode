/**
 * @param {number[]} nums
 * @return {number}
 * 
 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 */
var firstMissingPositive = function(nums) {
    let i = 0;

    // cyclic sort
    while(i<nums.length){
        let correctIndex = nums[i] -1;
        if(correctIndex >=0 && correctIndex < nums.length && nums[i] != nums[correctIndex]){
            [nums[i],nums[correctIndex]] = [nums[correctIndex],nums[i]];
        }
        else{
            i++;
        }
    }

    // return missing smallest positive
    for(let [index,element] of nums.entries()){
        if(element != index+1){
            return index+1;
        }
    }

    return nums.length+1;
};

var firstMissingPositiveUsingHashTable = function(nums) {
    let hash = {};

    // push all elements into hash
    for (let element of nums) {
        if (!(element in hash)) {
            hash[element] = true;
        }
    }

    // find missing smallest positive
    for (let index = 1; index <= nums.length; index++) {
        if (!(index in hash)) return index;
    }

    return nums.length + 1;
};

console.log(firstMissingPositive([1,2,0]));

// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.