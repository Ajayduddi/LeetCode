// Given a sorted array of distinct integers and a target value, return the index if the target is found. 
// If not, return the index where it would be if it were inserted in order.

var searchInsert = function (nums, target) {
  let a, b;
  for (let [index, i] of nums.entries()) {
    if (i == target) {
      return index;
    }

    if (nums[0] > target) {
      return 0;
    }

    if (i < target) {
      a = index;
    }

    if (nums[index - 1] < target && i > target) {
      b = index;
    }
  }

  return a + 1;
};

console.log(searchInsert([1, 3, 5, 6], 0));
