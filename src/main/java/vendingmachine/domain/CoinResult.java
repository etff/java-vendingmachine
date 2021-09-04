package vendingmachine.domain;

import java.util.Collections;
import java.util.Map;

public class CoinResult {
    private Map<Integer, Integer> result;
    private int remains;

    public CoinResult() {
    }

    public CoinResult(Map<Integer, Integer> result, int remains) {
        this.result = result;
        this.remains = remains;
    }

    public Map<Integer, Integer> getChanges() {
        return Collections.unmodifiableMap(result);
    }

    public int getRemains() {
        return remains;
    }
}
