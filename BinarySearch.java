class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) 
            return -1;
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }

        int mid = nums.length / 2;
        int start = 0;
        int end = nums.length - 1;
        
        while ((end - start) >= 1) {
            if (nums[mid] == target) 
                return mid;

            if (target > nums[mid]) 
                start = ++mid;
            else
                end = mid;
            
            mid = start + (end - start) / 2;
        }

        if (mid == target) 
            return mid;
            
        return -1;
    }
}

/*
 * Bierzemy indeksy start, end, mid
 * jeżeli nums[mid] == target, zwracamy indeks
 * jeżeli target > nums[mid], ustawiamy start na mid, ustawiamy mid na (end - start) / 2
 * jeżeli target < nums[mid], ustawiamy end na mid, ustawiamy na (end -  start) / 2
 * Robimy powyższe w pętli while, dopóki
 */
