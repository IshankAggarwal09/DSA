class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        int minPush = 0;
        Arrays.sort(freq);
        for (int i=25, pushCount=0; i>=0; i--) {
            int currEleIndex = 25 - i;
            if (currEleIndex % 8 == 0) {
                pushCount++;
            }
            minPush += freq[i] * pushCount;
        }
        return minPush;
    }
}