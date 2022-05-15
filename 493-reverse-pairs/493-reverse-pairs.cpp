
int mergeArray(vector<int>& nums, int start, int end, int mid) {
   // store count of reverse pairs for given arrays
    int cnt = 0;
    int j = mid + 1;
	
	//for every element of left array check.....
	// if condition met increment count of j..
	//else break the loop and count the increment in j
    for(int i=start; i <= mid; ++i) {
        while(j <= end && nums[i] > 2LL * nums[j]) {
            j++;
        }
        cnt += (j - (mid + 1));
    }
    
    vector<int> temp;
    int low = start;
    int high = mid+1;
	
	// merge array in sorted order..
    while(low <= mid && high <= end) {
        if(nums[low] <= nums[high]) {
            temp.push_back(nums[low++]);
        } else {
            temp.push_back(nums[high++]);
        }
    }
    while(low <= mid) {
        temp.push_back(nums[low++]);
    }
    while(high <= end) {
        temp.push_back(nums[high++]);
    }
    
    for(int i=start; i<=end; ++i) {
        nums[i] = temp[i - start];
    }
    
    return cnt;
}

// Divide the array and then merge

int mergeSort(vector<int>& nums, int start, int end) {
    if(start >= end) {
        return 0;
    }
	//get mid of the range..
    int mid = (start + end) / 2;
	//divide left half..
    int reversePair = mergeSort(nums, start, mid);
	
	//divide right half..
    reversePair += mergeSort(nums, mid + 1, end);
	
	// merge the left and right half...
    reversePair += mergeArray(nums, start, end, mid);
	
    return reversePair;
}

class Solution {
public:
    int reversePairs(vector<int>& nums) {
        return mergeSort(nums, 0, nums.size() - 1);
    }
};