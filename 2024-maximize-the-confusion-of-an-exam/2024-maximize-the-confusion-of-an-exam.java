class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int left = 0;
        int right = 0;
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(answerKey.charAt(right), map.getOrDefault(answerKey.charAt(right), 0) + 1);
            while (Math.min(map.getOrDefault('T', 0), map.getOrDefault('F', 0)) > k) {
                map.put(answerKey.charAt(left), map.get(answerKey.charAt(left))-1);
                left++;
            }
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        return answer;
    }
}