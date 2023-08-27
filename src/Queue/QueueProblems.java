package Queue;

import java.util.Deque;
import java.util.LinkedList;

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

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new LinkedList<>();
        int n = nums.length;
        int[] maxWindow = new int[n-k+1];
        int i=0, j=0;

        while(i<k) {
            while(!d.isEmpty() && nums[d.getLast()]<=nums[i])
                d.removeLast();

            d.addLast(i);
            i++;
        }

        while(i<n) {
            maxWindow[j++] = nums[d.getFirst()];

            //remove out of window
            while(!d.isEmpty() && (i-d.getFirst())>=k)
                d.removeFirst();

            //remove all the element in deque which is less than current element
            while (!d.isEmpty() && nums[d.getLast()]<= nums[i])
                d.removeLast();

            d.addLast(i);
            i++;
        }
        maxWindow[j++] = nums[d.getFirst()];
        return maxWindow;
    }
}
