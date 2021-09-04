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
        Map<Integer, Integer> newMap = new TreeMap<>(Collections.reverseOrder());
        newMap.putAll(map);

        for (Map.Entry<Integer, Integer> coin : newMap.entrySet()) {
            for (int i = 0; i < coin.getValue(); i++) {
                int subract = remains - coin.getKey();
                if (subract > 0) {
                    result.put(coin.getKey(), result.getOrDefault(coin.getKey(), 0) + 1);
                    remains = subract;
                }
            }
        }
        return new CoinResult(result, remains);
    }
}
