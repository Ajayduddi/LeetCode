/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findErrorNums = function(nums) {
    
    // cyclic sort
    let i=0;
    while(i<nums.length){
        let correct = nums[i] -1;
        if(nums[i] == nums[correct]) i++;
        else [nums[i],nums[correct]] = [nums[correct],nums[i]];
    }

    // find duplicate and missing
    for(let [index,element] of nums.entries()){
        if(element != index+1) return [element,index+1];
    }

    return [-1,-1];
};


console.log(findErrorNums([3,2,2]));