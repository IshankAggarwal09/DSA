class Solution {
    int i;
    public List<String> braceExpansionII(String expression) {
        i = 0;
        List<String> ans = nextExpression(expression);
        Collections.sort(ans);
        return ans;
    }
    List<String> nextExpression(String s) {
        List<String> ans = new ArrayList<>();
        while (i < s.length() && s.charAt(i) != '}' && s.charAt(i) != ',') {
            Set<String> next = nextTerm(s);
            if (ans.size() == 0) {
                ans.addAll(next);
            } 
            else {
                List<String> newAns = new ArrayList<>();
                for(String s2 : ans) {
                    for (String s3 : next) {
                        newAns.add(s2 + s3);
                    }
                }
                ans = newAns;
            }
        }
        return ans;
    }
    Set<String> nextTerm(String s) {
        Set<String> ans = new HashSet<>();
        if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
            ans.add(String.valueOf(s.charAt(i)));
            i++;
        } 
        else {
            while (s.charAt(i) != '}') {
                i++;
                ans.addAll(nextExpression(s));
            }
            i++;
        }
        return ans;
    }
}