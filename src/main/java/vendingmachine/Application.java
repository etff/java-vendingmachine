package vendingmachine;

import vendingmachine.application.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(InputView.askVendingMachineRemains());
        vendingMachine.addItems(InputView.askVendingMachineItems());
        vendingMachine.insertMoney(InputView.askUserMoney());

        while (!vendingMachine.canBuy()) {
            OutputView.showUserMoney(vendingMachine.getRemainUserMoney());
            vendingMachine.purchase(InputView.askItemBuy());
        }
        OutputView.showCoinResult(vendingMachine.getCoinResult());
    }
}
