package Recursion;

public class Intro {
    // functions that calls itself

    // stackoverflow!
    static void fun() {
        System.out.println("hello world!");
        fun();
    }

    // prints natural numbers from n to 1
    static void printNNumbers(int n) {
        // base case
        if (n < 1) {
            return;
        }
        System.out.println(n);
        printNNumbers(n - 1);
    }

    // prints n natural numbers form 1 to n
    static void printNaturalNumbers(int n, int i) {
        // base case
        if (i > n) {
            return;
        }
        System.out.println(i);
        printNaturalNumbers(n, i + 1);
    }

    // better approach
    static void printNaturalNumbers(int n) {
        if (n == 0) {
            return;
        }
        printNaturalNumbers(n - 1);
        System.out.println(n);
    }

    static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // nth fibonacci term
    static int fibonacci(int n) {
        // 0 1 1 2 3 5 8 13
        // fib(n) = fib(n-2) + fib(n-1)
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    // n = 5, 1 + 2 + 3 + 4 + 5 (use recurrsion)
    static int sumOfNNumber(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfNNumber(n - 1);
    }

    // every tail recurrsion can be converted into iteration => optimized since
    // doesn't take extra stack space.
    // some compilers automatically do tail optimization : gcc, but java can't
    // (project loom is trying)
    // recurrive codes are bad for oops
    // good for functional programming

    static boolean isPalindromRecursive(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) == str.charAt(end) && isPalindromRecursive(str, start + 1, end - 1))
            return true;
        else
            return false;

    }

    static boolean isPalindrome(String str) {
        return isPalindromRecursive(str, 0, str.length() - 1);
    }

    public static void main(String[] args) {
        String str = "MALAYALAM";
        System.out.println(isPalindrome(str));
    }
}
