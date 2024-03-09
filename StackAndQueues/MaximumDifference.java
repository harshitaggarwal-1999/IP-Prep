package StackAndQueues;

import java.util.Stack;

public class MaximumDifference {
    int findMaxDiff(int a[], int n) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int currelem = a[i];
            while (st.isEmpty() == false && a[st.peek()] > currelem) {
                int val = a[st.pop()];
                int nsl = a[st.peek()];
                int nsr = currelem;
                maxDiff = Math.max(maxDiff, Math.abs(nsl-nsr));
            }
        }
        return maxDiff;
    }

    int findMaxDiff2(int a[], int n) {
        // Your code here
        int[] ans1 = nextSmallerElementOnLeft(a, n);
        int[] ans2 = nextSmallerElementOnRight(a, n);

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.abs(ans1[i] - ans2[i]));
        }
        return ans;
    }

    int[] nextSmallerElementOnRight(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < n; i++) {
            int currelement = arr[i];
            while (st.isEmpty() == false && arr[st.peek()] > currelement) {
                ans[st.peek()] = currelement;
                st.pop();
            }
            st.push(i);
        }
        return ans;

    }

    int[] nextSmallerElementOnLeft(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int currelem = arr[i];
            while (st.isEmpty() == false && arr[st.peek()] > currelem) {
                ans[st.peek()] = currelem;
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}