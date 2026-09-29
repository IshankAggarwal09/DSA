class Solution {
    public int upperBound(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) <= target) {
                left = mid + 1;
            } 
            else {
                right = mid;
            }
        }
        return left;
    }
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        List<Integer> sorted1 = new ArrayList<>();
        List<Integer> sorted2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        sorted1.add(nums[0]);
        sorted2.add(nums[1]);
        for (int i=2; i<n; i++) {
            int greater1 = sorted1.size() - upperBound(sorted1, nums[i]);
            int greater2 = sorted2.size() - upperBound(sorted2, nums[i]);
            if (greater1 > greater2) {
                arr1.add(nums[i]);
                int pos = upperBound(sorted1, nums[i]);
                sorted1.add(pos, nums[i]);
            }
            else if (greater2 > greater1) {
                arr2.add(nums[i]);
                int pos = upperBound(sorted2, nums[i]);
                sorted2.add(pos, nums[i]);
            }
            else {
                if (arr1.size() <= arr2.size()) {
                    arr1.add(nums[i]);
                    int pos = upperBound(sorted1, nums[i]);
                    sorted1.add(pos, nums[i]);
                }
                else {
                    arr2.add(nums[i]);
                    int pos = upperBound(sorted2, nums[i]);
                    sorted2.add(pos, nums[i]);
                }
            }
        }
        int[] result = new int[n];
        int index = 0;
        for (int num : arr1) {
            result[index++] = num;
        }
        for (int num : arr2) {
            result[index++] = num;
        }
        return result;
    }
}