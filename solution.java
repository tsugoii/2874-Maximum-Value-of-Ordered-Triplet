class Solution {
    public long maximumTripletValue(int[] nums) {
        // If there aren't enough values for a triplet
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        // Max Value, Max Value of left of index and right of index
        long maxVal = 0;
        // [max 0... i-1]
        int[] maxLeft = new int[n];
        // max of left is going to be at 0 index, since middle has to start at index 1 
        maxLeft[0] = 0;
        // [max i+1... n-1]
        int[] maxRight = new int[n];
        // max of right is going to be middle - 1
        maxRight[n - 1] = 0;

        // From second element to the end
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i - 1]);
        }
        System.out.println("maxLeft: " + java.util.Arrays.toString(maxLeft));

        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i + 1]);
        }
        System.out.println("maxRight: " + java.util.Arrays.toString(maxRight));
        // From all possible middle indicies
        for (int j = 1; j < n  - 1; j++) {
            // For current idex j, maxLeft[j] is max of nums[i] for i < j
            // maxRight[j] holds max of nums[k] where j < k
            // Then calculates value of triplet throuh i - j * k
            long currentValue = (long) ((maxLeft[j] - nums[j]) * maxRight[j]);

            // If current value is greater than max, update
            maxVal = Math.max(maxVal, currentValue);
        }
        // Retun maximum triplet value found
        return maxVal;
    }
}
