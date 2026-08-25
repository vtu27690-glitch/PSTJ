class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];

        int currentMax = nums[0];
        int maxSum = nums[0];

        int currentMin = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];

            // Maximum subarray sum using Kadane's algorithm
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            // Minimum subarray sum
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);
        }

        // All elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum of normal and circular subarray
        return Math.max(maxSum, totalSum - minSum);
    }
}

Input
nums =
[1,-2,3,-2]
Output
3
Expected
3
