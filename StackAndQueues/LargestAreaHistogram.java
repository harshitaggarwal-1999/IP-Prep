package StackAndQueues;

import java.util.*;

public class LargestAreaHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        Stack<Integer> st = new Stack<>();
        int omax = 0;
        // isme equal t height isiliye le rhe hai taaki hum ye maane ki heihgt.length par ek histogram hai of height 0 taaki saare khud hi calculate ho jae leftover elements in stack ke liye alag se loop na likhna pade
        for (int i = 0; i <= heights.length; i++) {
            // 0 issiliye matalb hum end me pahcuh gye and last vaale ke liye hum 0 llenge
            // taaki vo calculate hi na ho as 0 into anything is 0
            int val = (i == heights.length) ? 0 : heights[i];
            while (st.isEmpty() == false && heights[st.peek()] > val) {
                // is me we will take iterate over the whole array and then we will check kya
                // hmara current element stack ke top most ko solve karsakta hai ya nahi if yes
                // we will start solving and calculating the omax but agar kisi point par nsl ke
                // liye stack empty hota hai to vaha hum -1 karenge ye hum issiliye karenge taak
                // nsr-nsl-1 = (nsr-nsl +1)-2(for excluding jo chote hai)
                int tbs = st.pop();
                int nsr = i;
                int nsl = st.isEmpty() ? -1 : st.peek();
                omax = Math.max(heights[tbs] * (nsr - nsl - 1), omax);
            }
            st.push(i);
        }
//        while (st.isEmpty() == false) {
//            // ab jo elements back gye hinge stack me unn elements ka next smaller element
//            // in right exist hi nahi karega to calculation ke liye h8um uss nsr ko heihgts
//            // array ke length ke equal caloculate kar lenge
//            int height = heights[st.pop()];
//            int nsr = heights.length;
//            int nsl = st.isEmpty() ? -1 : st.peek();
//            omax = Math.max(omax, height * (nsr - nsl - 1));
//        }
        return omax;

    }
}