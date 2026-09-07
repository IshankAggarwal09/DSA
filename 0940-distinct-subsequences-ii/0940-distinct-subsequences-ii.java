class Solution {
    public int distinctSubseqII(String s) {
        int[] freq = new int[26];
        int total = 0;
        int MOD = (int)1e9 + 7;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            int oldTotal = total;
            int newSub = (oldTotal + 1 - freq[idx] + MOD) % MOD;
            total = (total + newSub) % MOD;
            freq[idx] = (freq[idx] + newSub) % MOD;
        }
        return total;
    }
}