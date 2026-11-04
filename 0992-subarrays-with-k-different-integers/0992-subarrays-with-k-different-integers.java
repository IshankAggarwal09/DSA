class Solution {
    public int isValid(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return isValid(nums, k) - isValid(nums, k-1);
    }
}