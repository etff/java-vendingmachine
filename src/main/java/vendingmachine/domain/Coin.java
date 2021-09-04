package vendingmachine.domain;

/**
 * 동전.
 */
public enum Coin {
    /**
     * 10원
     */
    COIN_10(10),
    /**
     * 50원
     */
    COIN_50(50),
    /**
     * 100원
     */
    COIN_100(100),
    /**
     * 500원
     */
    COIN_500(500);

    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
