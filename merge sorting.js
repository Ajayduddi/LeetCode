/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArray = function (nums) {
    let end = nums.length - 1;
    let start = 0
    mergesort(start, end);

    function mergesort(start, end) {
        if (start < end) {
            let mid = Math.floor((start + end) / 2);
            mergesort(start, mid);
            mergesort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    function merge(start, mid, end) {
        let i = start, j = mid + 1, k = start;
        let arr = [];

        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                arr[k] = nums[j];
                k++;
                j++;
            } else {
                arr[k] = nums[i];
                k++;
                i++;
            }
        }

        if (i > mid) {
            while (j <= end) {
                arr[k] = nums[j];
                j++;
                k++;
            }
        }
        else {
            while (i <= mid) {
                arr[k] = nums[i];
                i++;
                k++;
            }
        }

        for (let i = start; i <= end; i++) {
            nums[i] = arr[i];
        }
    }

    return nums;
};

console.log(sortArray([1,2,3,4,1,1,1,2,3,4,5,7,8,9,10]))