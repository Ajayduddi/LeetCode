var intersection1 = function (nums1, nums2) {
    let len1 = nums1.length, len2 = nums2.length;
    let arr = [];

    if (len1 > len2) {
        for (let i of nums2) {
            for (let j of nums1) {
                if (i == j) {
                    arr.push(i);
                }
            }
        }
    }
    else {
        for (let i of nums1) {
            for (let j of nums2) {
                if (i == j) {
                    arr.push(i);
                }
            }
        }
    }

    let set = new Set(arr);
    return [...set];

};

// method 2
// efficent method
var intersection = function (nums1, nums2) {
    let set1 = new Set(nums1);
    let set2 = new Set(nums2);

    return [...set2].filter(num => set1.has(num));
};

console.log(intersection([1, 2, 2, 1], [2, 2]));