//  track of the kth highest test score from applicants in real-time.
// returns the kth highest test score after a new score has been submitted

class kthLargest { 
    constructor(k, nums) {
        this.arr = [...nums];
        this.x = k;
        this.minHeap = [];

        //add all the elements to the minHeap
        for(let i = 0; i < this.arr.length; i++){
            this.add(this.arr[i]);
        }
    }

    /*
    The error you encountered, "time limit exceeded," is likely due to the inefficiency in your current approach 
    when handling large datasets. The add method sorts the array every time a new value is added, which has a time 
    complexity of 𝑂(𝑛 log𝑛) per operation. When dealing with large datasets, this approach becomes too slow.*/
    adddefault(val) {
        this.arr.push(val);
        let myarr = [];
        myarr = [...this.arr];
        myarr.sort((a,b) => a-b);
        let reversearr = myarr.reverse();
        return reversearr[this.x-1];
    }

    /*
     * To optimize this, you can use a min-heap (also known as a priority queue). In a min-heap, 
     * the smallest element is always at the root will be the kth largest element. By maintaining 
     * a min-heap of size k with top k largest elements, you can efficiently find the k-th largest element.
     * If the heap grows larger than k, remove the smallest element.
     */
    add(val) { 
        this.minHeap.push(val);
        this.minHeap.sort((a,b) => a-b);
        if (this.minHeap.length > this.x) {
            this.minHeap.shift(0,-1); //remove the smallest element
        }

        return this.minHeap[0];
    }

}

let kthLargestObj = new kthLargest(3, [4, 5, 8, 2]);
console.log(kthLargestObj.add(3));
console.log(kthLargestObj.add(5));
console.log(kthLargestObj.add(10));
console.log(kthLargestObj.add(9));
console.log(kthLargestObj.add(4));