class Solution {
    private boolean isValid(int[] arr, int days, int m, int k) {
        int n = arr.length;
        int count = 0;
        int numB = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] <= days) {
                count++;
            }
            else {
                numB += count/k;
                count = 0;
            }
        }
        numB += count/k;
        if (numB >= m) {
            return true;
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int ans = -1;
        int start = Integer.MAX_VALUE;
        int end = 0;
        for (int i=0; i<n; i++) {
            start = Math.min(start, bloomDay[i]);
            end = Math.max(end, bloomDay[i]);
        }
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (isValid(bloomDay, mid, m, k)) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}