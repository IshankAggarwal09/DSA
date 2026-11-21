class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map will store {number, index}
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i=0; i<nums.length; i++) {
            int complement = target - nums[i];

            // If map has the complement we found our pair
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            //Otherwise, store the current number and its index
            map.put(nums[i], i);
        }
        return new int[0];
    }
}