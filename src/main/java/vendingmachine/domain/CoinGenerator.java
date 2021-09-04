package vendingmachine.domain;

import com.woowahan.techcourse.utils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinGenerator {
    public static final int COIN_10 = 10;
    public static final int COIN_100 = 100;
    public static final int COIN_500 = 500;
    private Map<Integer, Integer> coins = new HashMap<>();

    public CoinGenerator(int remainAmount) {
        this.coins = generateCoins(remainAmount);
    }

    public Map<Integer, Integer> getCoins() {
        return coins;
    }

    private Map<Integer, Integer> generateCoins(int amount) {
        int remainAmount = amount;
        while (remainAmount > 0) {
            remainAmount = pickCoins(remainAmount);
        }
        return coins;
    }

    private int pickCoins(int remainAmount) {
        int pick = Randoms.pick(List.of(COIN_10, COIN_100, COIN_500));
        int subtractedAmount = remainAmount - pick;
        if (subtractedAmount >= 0) {
            coins.put(pick, coins.getOrDefault(pick, 0) + 1);
            return subtractedAmount;
        }
        return remainAmount;
    }
}
