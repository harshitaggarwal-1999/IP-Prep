package Arrays.Arrays7;

public class GasStation {

    // note this can be done by segregating the loops for first calculating the gasSum and costSum
    public int canCompleteCircuit(int[] gas, int[] cost) {

        // in this the algorithms works like we need to find the delta between gas and cost component and then the delta prefix with deltaPrefix[0] = gas[0]-cost[0] = delta[0] and the smallest deltaprefix the answer next to that is the main answer

        // edge cases if i == n-1 then answer is n but n index doesnot exists in the 0 based indexing so the smallestDeltaPrefix + 1 should be done modulo with 'n'
        // edge case gas = [2, 0 , 0, 0, 0] cost = [0, 1, 0 , 0 , 0] so the answer can be anything but we have to find the whole cycle so till the minDeltaPrefix >= deltaPrefix[i] all are our answers

        int n = gas.length;
        int[] delta = new int[n];
        int[] deltaPrefix = new int[n];
        deltaPrefix[0] = delta[0] = gas[0] - cost[0];
        int gasSum = gas[0];
        int costSum = cost[0];
        int minDeltaPrefix = (gas[0] - cost[0]);

        int minDeltaPrefixIdx = 0;
        int i = 0;
        for (i = 1; i < n; i++) {
            // cost sum and gas sum
            costSum = costSum + cost[i];
            gasSum = gasSum + gas[i];

            // calculate delta and deltaPrefix
            delta[i] = gas[i] - cost[i];
            deltaPrefix[i] = deltaPrefix[i - 1] + delta[i];

            // System.out.println("minDeltaPrefix: " + minDeltaPrefix + " delta[i]: " + delta[i] + " deltaprefix[i] : "
            //         + deltaPrefix[i] + " deltaprefix[i-1] : " + deltaPrefix[i - 1]);

            if (minDeltaPrefix >= deltaPrefix[i]) {
                minDeltaPrefix = deltaPrefix[i];
                minDeltaPrefixIdx = i;
            }
        }

        if (costSum > gasSum) {
            return -1;
        }

        return ((minDeltaPrefixIdx + 1) % n);

    }
}