import java.util.Scanner;

public class factorialOfNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int ans = helperFunction(n);
        System.out.println(ans);
    }

    private static int helperFunction(int n) {
        if(n == 0 || n == 1)return 1;
        // way 1
        // return (n * helperFunction(n-1));

        // way 2
        int factorialrest = helperFunction(n-1);
        int ans  = n* factorialrest;

        return ans;
    }
}
