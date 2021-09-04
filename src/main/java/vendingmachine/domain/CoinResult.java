package vendingmachine.domain;

import java.util.Collections;
import java.util.Map;

public class CoinResult {
    private final Map<Integer, Integer> result;
    private final int remains;

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
