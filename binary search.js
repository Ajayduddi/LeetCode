var search = function(nums, target) {
    let start = 0;
    let end = nums.length-1;
    let count = 0;

    while (count < nums.length) {

        let mid = Math.round((start + end) / 2);
        
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]>target){
            end = mid-1;
        }
        else if(nums[mid]<target){
            start = mid+1;
        }

        count++;
    }

    return -1;
    
};

console.log(search([-1, 0, 3, 5, 9, 12],12));


// efficent method

// var search = function (arr, target) {
//   let start = 0,end = arr.length - 1;

//   while (start <= end) {
//     let mid = Math.floor((start + end) / 2);

//     if (arr[mid] === target) {
//       return mid;
//     } else if (arr[mid] > target) {
//       end = mid - 1;
//     } else {
//       start = mid + 1;
//     }
//   }

//   return -1;
// };