class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int even = 0;
        int odd = n-1;
        for (int i=0; i<n; i++) {
            if (nums[i] % 2 == 0) {
                result[even] = nums[i];
                even++;
            }
            else {
                result[odd] = nums[i];
                odd--;
            }
        }
        return result;
    }
}