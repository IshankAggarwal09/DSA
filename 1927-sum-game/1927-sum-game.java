class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n/2;
        int sum1 = 0;
        int sum2 = 0;
        int count1 = 0; 
        int count2 = 0;
        for (int i=0; i<half; i++) {
            if (num.charAt(i) == '?') {
                count1++;
            }
            else {
                sum1 += num.charAt(i) - '0';
            }
        }
        for (int i=half; i<n; i++) {
            if (num.charAt(i) == '?') {
                count2++;
            }
            else {
                sum2 += num.charAt(i) - '0';
            }
        }

        int total = count1 + count2;
        if (total % 2 == 1) {
            return true;
        }
        return 2 * (sum1 - sum2) != 9 * (count2 - count1);
    }
}