public class Main {
    public static void main(String args[]) {
        System.out.println("hello world");
        System.out.println(fib(50));
    }

    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}