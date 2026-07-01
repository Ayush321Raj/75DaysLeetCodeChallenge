class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalGas += diff;
            currGas += diff;

            if (currGas < 0) {
                start = i + 1;
                currGas = 0;
            }
        }

        return totalGas >= 0 ? start : -1;
    }
}