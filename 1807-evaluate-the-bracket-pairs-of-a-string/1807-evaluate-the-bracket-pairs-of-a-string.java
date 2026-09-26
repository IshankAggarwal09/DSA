class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int l = 0;
        while (l < s.length()) {
            if (s.charAt(l) != '(') {
                sb.append(s.charAt(l++));
            }
            else {
                int r = l + 1;
                while (s.charAt(r) != ')') {
                    r++;
                }
                String sub = s.substring(l + 1, r);
                map.put(sub, map.getOrDefault(sub, "?"));
                sb.append(map.get(sub));
                l = r + 1;
            }
        }
        return sb.toString();
    }
}