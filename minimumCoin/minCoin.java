package minimumCoin;

import java.util.HashMap;
import java.util.Map;

public class MinCoin {

    public static void main(String args[]) {
        Integer[] coins = { 1, 4, 5 };
        Integer m = 150;

        MinCoin minCoin = new MinCoin();

        System.out.println(minCoin.minimum_coins(m, coins, new HashMap<Integer, Integer>()));
        System.out.println(minCoin.bottomUpMinimumCoin(m, coins));

    }

    public Integer minimum_coins(Integer m, Integer[] coins, Map<Integer, Integer> memo) {
        Integer answer;
        if (m == 0)
            answer = 0;

        else if (memo.containsKey(m)) {
            return memo.get(m);
        } else {
            answer = null;
            for (Integer coin : coins) {
                Integer subProblem = m - coin;
                if (subProblem < 0)
                    continue;
                Integer subAns = minimum_coins(subProblem, coins, memo);
                if (subAns != null)
                    answer = min_ignore_null(answer, subAns + 1);
            }
        }
        memo.put(m, answer);
        return answer;
    }

    private Integer min_ignore_null(Integer a, Integer b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        return Math.min(a, b);
    }

    public Integer bottomUpMinimumCoin(Integer m, Integer[] coins) {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        memo.put(0, 0);
        for (Integer i = 1; i <= m; i++) {
            for (Integer coin : coins) {
                Integer subProblem = i - coin;
                if (subProblem < 0)
                    continue;
                memo.put(i, min_ignore_null(memo.get(i), memo.get(subProblem) + 1));
            }
        }
        return memo.get(m);
    }
}
