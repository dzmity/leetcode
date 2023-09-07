class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int[] diff = new int[cost.length];
        int totalDiff = 0;
        for (int i = 0; i < diff.length; i++) {
            diff[i] = gas[i] - cost[i];
            totalDiff += diff[i];
        }

        if (totalDiff < 0) {
            return -1;
        }

        int stationIndex = 0;
        int currentTank = 0;
        for (int i = 0; i < diff.length; i++) {
            if (currentTank + diff[i] < 0) {
                i = findNextPositiveDiff(diff, i + 1);
                stationIndex = i;
                currentTank = diff[i];
            } else {
                currentTank += diff[i];
            }
        }
        return stationIndex;
    }

    private int findNextPositiveDiff(int[] diff, int station) {
        while (diff[station] <= 0) {
            station++;
        }
        return station;
    }
}
