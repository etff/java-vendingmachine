package vendingmachine.domain;

import com.woowahan.techcourse.utils.Randoms;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoinGenerator {
    private Map<Integer, Integer> coins;

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
        int pick = Randoms.pick(getCoinEntries());
        int subtractedAmount = remainAmount - pick;
        if (subtractedAmount >= 0) {
            this.coins.put(pick, this.coins.getOrDefault(pick, 0) + 1);
            return subtractedAmount;
        }
        return remainAmount;
    }

    private List<Integer> getCoinEntries() {
        return Stream.of(Coin.values())
                .map(Coin::getValue)
                .collect(Collectors.toList());
    }
}
