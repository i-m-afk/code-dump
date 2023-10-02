public class Pow {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, n / 2);
        }
    }

    private boolean check(double x, int pow) {
        double result = myPow(x, pow);
        double standard = Math.pow(x, pow);
        double relativeError = Math.abs((result - standard) / standard);
        double tolerance = 1e-6;
        return relativeError < tolerance;
    }

    private Object[] generator() {
        double randomX = (float) (Math.random() * 100);
        if (randomX == 0)
            randomX = 1;
        int randomPow = (int) (Math.random() * 100);
        return new Object[] { randomX, randomPow };
    }

    public static void main(String[] args) {
        while (true) {
            Pow pow = new Pow();
            Object[] params = pow.generator();
            double x = (double) params[0];
            int n = (int) params[1];
            System.out.println("x: " + x + " n: " + n);
            if (!pow.check(x, n)) {
                double diff = Math.abs(Math.pow(x, n) - pow.myPow(x, n));
                System.out.println("Pow: " + Math.pow(x, n));
                System.out.println("myPow: " + pow.myPow(x, n));
                System.out.println("Diff: " + diff);
                System.out.println("Error: " + x + " " + n);
                break;
            }
        }
    }
}
