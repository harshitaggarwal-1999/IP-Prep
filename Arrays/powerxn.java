class Solution {
    public double myPow(double x, int n) {
        double res = pow(x, Math.abs((long) (n)));
        return n < 0 ? 1 / res : res; // Negative?
    }

    double pow(double x, long n) {
        if (n == 0) return 1.0; // Base case x^0
        double res = pow(x, n / 2); // ex: x^25
        res = res * res; // ex: x^25 * x^25 = x^50
        if (n % 2 == 1) res = res * x; // (x^2 * x^2) * x^1 = x^5
        return res;
    }
}