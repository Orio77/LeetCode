/**
 * MedianOfTwoSortedArrays
 */
public class MedianOfTwoSortedArrays {

    
}


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int mid = (n + m ) / 2;
        
        if (n == 0) {
            if (m == 1) {
                return nums2[0];
            }
            else if (m % 2 == 0) {
                return (nums2[m/2] + nums2[m/2+1] / 2);
            }
            else {
                return nums2[m/2];
            }
        }
        else if (m == 0) {
            if (n == 1) {
                return nums2[0];
            }
            else if (n % 2 == 0) {
                return (nums2[n/2] + nums2[n/2+1] / 2);
            }
            else {
                return nums2[n/2];
            }
        }

        int start = n / 2;
        int end = m / 2;



        // Even case
        if (mid % 2 == 0) {
            
        }
        else if (mid % 2 != 0) { // remove if
            while (start != end) {
                mid = start + (end - start) / 2;

                if (condition) {
                    
                }
            }
        }
    }

}