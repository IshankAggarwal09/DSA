class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int k=0; k<n; k++) {
            for (int l=0; l<n; l++) {
                int sum = -(nums3[k] + nums4[l]);
                count += map.getOrDefault(sum, 0);
            }
        }
        return count;
    }
}