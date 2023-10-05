import java.util.HashMap;
import java.util.Map;

class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> waysPerSteps = new HashMap<>();
        for (int i = 0; i <= 3; i++) {
            waysPerSteps.put(i, i);
        }
        return climb(n, waysPerSteps);
    }

    private int climb(int n, Map<Integer, Integer> waysPerSteps) {
        if (waysPerSteps.containsKey(n)) {
            return waysPerSteps.get(n);
        }

        int ways = 0;

        for (int i = n - 1; i >= n - 2; i--) {
            if (waysPerSteps.containsKey(i)) {
                ways += waysPerSteps.get(i);
            } else {
                int stepWays = climb(i, waysPerSteps);
                waysPerSteps.put(i, stepWays);
                ways += stepWays;
            }
        }

        waysPerSteps.put(n, ways);
        return ways;
    }
}
