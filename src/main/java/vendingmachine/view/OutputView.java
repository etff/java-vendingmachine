package vendingmachine.view;

import vendingmachine.domain.CoinResult;

import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void showUserMoney(int money) {
        System.out.println(String.format("남은 금액: %d 원", money));
    }

    public static void showCoinResult(CoinResult coinResult) {
        System.out.println("남은 금액: " + coinResult.getRemains());
        System.out.println("잔돈");

        Map<Integer, Integer> changes = coinResult.getChanges();
        for (Map.Entry<Integer, Integer> map : changes.entrySet()) {
            System.out.println(String.format("%d원 - %d", map.getKey(), map.getValue()));
        }
    }
}
