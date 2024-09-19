/*
 * array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * algorithm that runs in O(log n) time.
 * return the minimum element of this array.
 */

var findMin = function (nums) {
    let start = 0, end = nums.length - 1, mid;
    while (true) {
        mid = Math.floor((start + end) / 2);
        if (nums[mid + 1] < nums[mid]) {
            return nums[mid + 1];
        }
        else if (nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
        else if (nums[end] > nums[mid]) {
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }
    }
};

console.log(findMin([4, 5, 6, 7, 0, 1, 2]));


/*
 * The main idea is, the element is said to be minimum in the rotated sorted array if the previous element to it is greater than it or there is no previous element(i.e. no rotation). We can do this using Binary search
 * Find the mid element i.e. mid = (low+high)/2
 * If the (mid+1)th element is less than mid element then return (mid+1)th element
 * If the mid element is less than (mid-1)th element then return the mid element
 * If the last element is greater than mid element then search in left half
 * If the last element is less than mid element then search in right half
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */

// method 2

var findMin1 = function (nums) {
    let left = 0, right = nums.length - 1;
    while (left < right) {
        let mid = Math.floor((left + right) / 2);

        if (nums[mid] < nums[right]) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return nums[left];
};

console.log(findMin1([4, 5, 6, 7, 0, 1, 2]));