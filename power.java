import java.util.Scanner;

public class power {
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);

        int x = scn.nextInt();
        int n = scn.nextInt();
        
        int ans = power(x,n);
        System.out.println(ans);
    }

    private static int power(int x, int n) {
        if(x == 1 || n == 0){
            return 1;
        }

        return (x*power(x,n-1));
    }
}
