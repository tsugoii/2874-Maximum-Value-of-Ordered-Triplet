class Solution {
    public long maximumTripletValue(int[] nums) {
        // Will handle case where values are negative
        long maxVal = 0;
        // For each possible middle index
        // j has to be at least 1 and at most n - 2 for i<j<k
        for (int j = 1; j < nums.length - 1; j++) {
            int maxLeft = 0;
            int maxRight = 0;
            // Iterate through cases where i < j
            for (int i = 0; i < j; i++) {
                // Update max if current is greater
                maxLeft = Math.max(maxLeft, nums[i]);
            }
            // Iterate through j < k
            for (int k = j + 1; k < nums.length; k++) {
                // update max if current is g reater
                maxRight = Math.max(maxRight, nums[k]);
            }
            // calculate (i, j, k) using maxRight and maxLeft and current j
            long currentValue  = (long) (maxLeft - nums[j]) * maxRight;
            maxVal = Math.max(maxVal, currentValue);
        }
        return maxVal;
    }
}
