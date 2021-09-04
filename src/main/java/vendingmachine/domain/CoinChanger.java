package vendingmachine.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CoinChanger {
    private final Map<Integer, Integer> result;
    private final Map<Integer, Integer> map;
    private int remains;

    public CoinChanger(Map<Integer, Integer> map, int remains) {
        this.map = map;
        this.remains = remains;
        this.result = new HashMap<>();
    }

    public CoinResult getResult() {
        Map<Integer, Integer> sortedMap = sortCoin();
        for (Map.Entry<Integer, Integer> coin : sortedMap.entrySet()) {
            subtractRemain(coin);
        }
        return new CoinResult(result, remains);
    }

    private void subtractRemain(Map.Entry<Integer, Integer> coin) {
        for (int i = 0; i < coin.getValue(); i++) {
            int subtract = remains - coin.getKey();
            if (subtract >= 0) {
                result.put(coin.getKey(), result.getOrDefault(coin.getKey(), 0) + 1);
                remains = subtract;
            }
        }
    }

    private Map<Integer, Integer> sortCoin() {
        Map<Integer, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(map);
        return sortedMap;
    }
}
