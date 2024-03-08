package StackAndQueues;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] ans = new int[temperatures.length];

        for (int i = 1; i < temperatures.length; i++) {
            int currtemp = temperatures[i];
            int count = 1;
            while (st.isEmpty() == false && temperatures[st.peek()] < currtemp) {
                ans[st.peek()] = count;
                count++;
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}