class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        boolean[] valid = new boolean[n];
        for (int i=0; i<n; i++) {
            if (nums[i] == key) {
                int left = Math.max(0, i-k);
                int right = Math.min(n-1, i+k);
                for (int j=left; j<=right; j++) {
                    valid[j] = true;
                }
            }
        }
        for (int i=0; i<n; i++) {
            if (valid[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}