class Solution2 {
    public long maximumTripletValue(int[] nums) {
        // If there aren't enough values for a triplet, return 0
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        long maxVal = 0;

        // Maintain the maximum value of nums[i] encountered so far.
        int maxI = nums[0];

        // Maintain the maximum value of (nums[i] - nums[j]) encountered so far,
        // considering all i < j.
        long maxDiffIJ = 0;

        // Iterate through the array starting from the second element (index 1)
        // as 'j' can be at least index 1.
        for (int j = 1; j < n; j++) {
            // For the current 'j', update maxVal by considering all previous 'i'
            // and all subsequent 'k'. The maximum (nums[i] - nums[j]) encountered
            // so far is stored in maxDiffIJ. We multiply this by the current nums[j]
            // (which could potentially be a 'k' in a previous iteration's context)
            // and update maxVal.
            maxVal = Math.max(maxVal, maxDiffIJ * nums[j]);

            // Update maxI with the maximum value encountered so far. This considers
            // the current nums[j] as a potential 'i' for future iterations.
            maxI = Math.max(maxI, nums[j]);

            // Update maxDiffIJ with the maximum value of (nums[i] - nums[j']) encountered so far,
            // where j' is the index of the previous iteration. Here, maxI holds the
            // maximum nums[i] seen before the current 'j'.
            maxDiffIJ = Math.max(maxDiffIJ, (long)maxI - nums[j]);
        }

        return maxVal;
    }
}
