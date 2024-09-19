var merge = function(nums1, m, nums2, n) {
    let i = m - 1;  // Index of last element in nums1's initial part
    let j = n - 1;  // Index of last element in nums2
    let k = m + n - 1;  // Index of last position in nums1

    // Merge in reverse order
    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k] = nums1[i];
            i--;
        } else {
            nums1[k] = nums2[j];
            j--;
        }
        k--;
    }

    // If nums2 still has elements left, add them to nums1
    while (j >= 0) {
        nums1[k] = nums2[j];
        j--;
        k--;
    }

};

nums1 = [1, 2, 3, 0, 0, 0];
nums2 = [2, 5, 6];
merge(nums1, 3, nums2, 3);
console.log(nums1);