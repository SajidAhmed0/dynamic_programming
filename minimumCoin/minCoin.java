package minimumCoin;

public class minCoin {
    private Integer min_ignore_null(Integer a, Integer b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        return Math.min(a, b);
    }
}
