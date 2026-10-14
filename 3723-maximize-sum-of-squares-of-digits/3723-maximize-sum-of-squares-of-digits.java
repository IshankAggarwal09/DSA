class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (num * 9 < sum) {
            return "";
        }
        char[] res = new char[num];
        Arrays.fill(res, '0');
        int nines = sum / 9; 
        int r = sum % 9;
        for (int i=0; i<nines; i++) {
            res[i] = '9';
        }
        if (r > 0) {
            res[nines] = (char) ('0' + r);
        }
        return new String(res);
    }
}