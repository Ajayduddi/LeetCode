// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times.You may assume that the majority element always exists in the array.

var majorityElement = function (nums) {
  let half = Math.round(nums.length / 2);
  nums.sort();
  let count = {};
  let ans;

  for (let i of nums) {
    if (i in count) {
      count[i] = count[i]+1;
    } else {
      count[i] = 1;
    }
  }

  for (let i in count) {
    if (count[i] >= half) {
      ans = i;
    }
  }

  return ans;
};

console.log(majorityElement([3, 2, 3]));