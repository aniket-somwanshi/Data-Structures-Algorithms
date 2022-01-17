class Solution {
public:
    // approach 2: O(log(m+n)), O(1)
    // try to partition the merged array into equal parts
    // the correct partition of m and n will give us the answer
    // eg. if we need 5 elements in each equal partition
    // we first try to partition m at 0 which means 0 elements from m and 5-0 ie 5 elemets from n
    // if it's not valid partition, go for 1
    // so partition m at 1 which means 1 elements from m and 5-1 ie 4 elemets from n
    // we can improve time by using binary search to decide which partition to go for next
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        // smaller array is always n1 
        if (nums2.size() < nums1.size()) return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.size();
        int n2 = nums2.size();
        
        int low = 0, high = n1;
        
        while (low <= high) {
            // making a partition ie a cut in n1
            int cut1 = (low + high)/2;
            // if cut1 is at 1 which means 1 elements from n1 and 5-1 ie 4 elemets from n2
            int cut2 = (n1 + n2 + 1)/2 - cut1;
            
            int left1 = cut1 == 0 ? INT_MIN : nums1[cut1-1];
            int left2 = cut2 == 0 ? INT_MIN : nums2[cut2-1];
            // if there are no elements in left half,
            // it should be INT_MIN so that it doesn't violated the valid partition consdition
            
            int right1 = cut1 == n1 ? INT_MAX : nums1[cut1];
            int right2 = cut2 == n2 ? INT_MAX : nums2[cut2];
            
            // check if cut is valid
            if (left1 <= right2 && left2 <= right1) {
                // got the answer
                // now check if it's even, go for middle 2 elements, else if odd, for only middle element 
                if ((n1+n2)%2 == 0) {
                    // biggest element in left half and smallest element from right half will be median
                    return (max(left1, left2) + min(right1, right2)) /2.0;
                }
                else {
                    // biggest element in left half will be the median
                    return max(left1, left2);
                }
            }
            else if (left1 > right2) {
                // left1 needs to be smaller than righ2, but it's not
                // so we need smaller element in left1,
                // so move high backwards
                high = cut1 - 1;
            }
            else low = cut1 + 1;
            
        }
        return 0.0;
    }
    
    // approach 1: O(m + n), O(1)
    // create a merged array and store only the middle element while creating
//     double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
//         int m = nums1.size();
//         int n = nums2.size();
        
//         int i = 0;
//         int j = 0;
        
//         int counter = 0;
//         int target = (m+n)/2;
//         int left_mid, right_mid;
        
//         while (i < m && j < n) {
//             if (nums1[i] <= nums2[j]) {
//                 counter++;
//                 if (counter == target) left_mid = nums1[i];
//                 else if (counter == target + 1) right_mid = nums1[i];
//                 i++;
//             }
//             else {
//                 counter++;
//                 if (counter == target) left_mid = nums2[j];
//                 else if (counter == target + 1) right_mid = nums2[j];
//                 j++;
//             }
//         }
        
//         while (i < m) {
//             counter++;
//             if (counter == target) left_mid = nums1[i];
//             else if (counter == target + 1) right_mid = nums1[i];
//             i++;
//         }
        
//         while (j < n) {
//             counter++;
//             if (counter == target) left_mid = nums2[j];
//             else if (counter == target + 1) right_mid = nums2[j];
//             j++;
//         }
//         // if odd return right_mid
//         if ((m+n) % 2 != 0) return right_mid;
//         else return ((double)left_mid + (double)right_mid)/2;
        
//         return 0;
// }    
    
    
};