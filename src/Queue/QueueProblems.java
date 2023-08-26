package Queue;

public class QueueProblems {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start =0, end, totalGas = 0;

        while(start<n) {
            if(gas[start] >= cost[start]) {
                end = (start+1) % n;
                totalGas = gas[start] - cost[start];

                while(start!=end  && totalGas+ gas[end] >= cost[end]) {
                    totalGas+= (gas[end]- cost[end]);
                    end = (end+1) % n;
                }
                if(start==end)
                    return start;
                if(end>start)
                    start = end;
                else
                    return -1;
            } else {
                start++;
            }
        }
        return -1;
    }
}
