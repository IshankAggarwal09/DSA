class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap();
        int prefixSum = 0;
        int count = 0;
        mpp.put(0,1);
        for (int i=0; i<n; i++) {
            prefixSum += nums[i];
            int remove = prefixSum - k;
            count += mpp.getOrDefault(remove, 0); 
            mpp.put(prefixSum, mpp.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}