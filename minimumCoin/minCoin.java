package minimumCoin;

public class minCoin {

    public static void main(String args[]) {

    }

    public Integer minimum_coins(Integer m, Integer[] coins) {
        Integer answer;
        if (m == 0)
            answer = 0;
        else {
            answer = null;
            for (Integer coin : coins) {
                Integer subProblem = m - coin;
                if (subProblem < 0)
                    continue;
                answer = min_ignore_null(answer, minimum_coins(subProblem, coins) + 1);
            }
        }
        return answer;
    }

    private Integer min_ignore_null(Integer a, Integer b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        return Math.min(a, b);
    }
}
