package minimumCoin;

public class MinCoin {

    public static void main(String args[]) {
        Integer[] coins = { 9, 10, 20, 5 };
        Integer m = 45;

        MinCoin minCoin = new MinCoin();

        System.out.println(minCoin.minimum_coins(m, coins));

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
                Integer subAns = minimum_coins(subProblem, coins);
                if(subAns != null)
                    answer = min_ignore_null(answer, subAns + 1);
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
