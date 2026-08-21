class Solution {
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        if (coins[0] == 1) {
            return k;
        }
        List<Integer> coinList = new ArrayList<Integer>();
        for (int i=0; i<coins.length; i++) {
            if (coins[i] == -1 ) {
                continue;
            }
            for (int j=i+1; j<coins.length; j++) {
                if (coins[j] % coins[i] == 0) {
                    coins[j] = -1;
                }
            }
            coinList.add(coins[i]);
        }
        long start = 0;
        long end = (long)coinList.get(coinList.size()-1) * k;
        return binarySearch(start, end, coinList, k);
    }
    long count;
    public long binarySearch(long start, long end, List<Integer> coins, int k) {
        long mid;
        long ans = 0;
        while(start <= end) {
            mid = (long)Math.ceil((double)(start+end)/2.0);
            count = 0;
            backTracking(coins, 0, k, 1,mid, 0);
            if (count >= k) {
                ans = mid;
                end = mid-1;
            } 
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    public void backTracking(List<Integer> coins, int idx, int k, long lcm, long target, int bitmask){
        if (idx >= coins.size()) {
            return;
        }        
        backTracking(coins, idx+1, k, lcm, target, bitmask);
        lcm = getLCM(lcm, coins.get(idx));
        bitmask = bitmask|(1<<idx);
        if (bitmask != 0) {
            if (Integer.bitCount(bitmask) % 2 == 0) {
                count -= target/lcm;
            } 
            else{
                count += target/lcm;
            }
        }
        backTracking(coins, idx+1, k, lcm, target, bitmask);
    }
    public long getLCM(long a, long b) {
        long gcd = getGCD(a, b);
        return (a/gcd)*(b/gcd)*gcd;
    }
    public long getGCD(long a, long b) {
        if (a < b) {
            long t = a;
            a = b;
            b = t;
        }
        while (b != 0) {
            long n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
}