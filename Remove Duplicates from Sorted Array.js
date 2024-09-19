var removeDuplicates = function(nums) {
    let set = new Set(nums);
    let arr = [];
    for(let i of set){
        arr.push(i);
    }
    return [...arr];
};

// return the no of unique elements
// var removeDuplicates = function(nums) {
//     if(nums.length == 0) return 0;
    
//     let k = 1;
//     for(let i=1; i<nums.length; i++){
//         if(nums[i] !== nums[i-1]){
//             nums[k]  = nums[i];
//             k++;
//         }
//     }

//     return k;
// };

nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
console.log(removeDuplicates(nums));


// same question but allow duplicates less than 3
var removeDuplicates1 = function(nums) {
    let k = 1;
    let count = 0;
    for(let i=1; i<nums.length; i++){
        if(nums[i] == nums[i-1]){
            count++;
        }
        if(nums[i] != nums[i-1]){
            count = 0;
        }
        if(count<2){
            nums[k] = nums [i];
            k++;
        }
    }

    return k;
};

nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
console.log(removeDuplicates1(nums));
