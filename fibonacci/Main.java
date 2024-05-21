import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[]) {
        System.out.println("hello world");
        System.out.println(fib(50, new long[50]));
        System.out.println(fibBottomUp(50));
    }

    public static long fib(int n, long[] intArray) {
        if (intArray[n - 1] != 0) {
            // System.out.println(intArray[n - 1]);
            return intArray[n - 1];
        } else {
            long result;
            if (n <= 2) {
                result = 1;
                intArray[n - 1] = result;
            } else {
                result = fib(n - 1, intArray) + fib(n - 2, intArray);
                intArray[n - 1] = result;
            }
            // System.out.println(result);
            return result;
        }

    }

    public static Long fibBottomUp(int n) {
        Map<Long, Long> memo = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            Long result;
            if (i <= 2)
                result = (long) 1;
            else {
                result = memo.get((long) i - 1) + memo.get((long) i - 2);
            }
            memo.put((long) i, result);
        }
        return memo.get((long) n);
    }
}