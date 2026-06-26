class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 0 || nums == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}