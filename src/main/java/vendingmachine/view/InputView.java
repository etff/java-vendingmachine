package vendingmachine.view;

import vendingmachine.domain.Item;
import vendingmachine.utils.ItemGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String BLANK = "";
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int askVendingMachineRemains() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            askVendingMachineRemains();
        }
        return 0;
    }

    public static List<Item> askVendingMachineItems() {
        System.out.println("상품명과 수량, 금액을 입력해 주세요.");
        try {
            String inputs = scanner.nextLine();
            return ItemGenerator.generateItem(inputs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            askVendingMachineItems();
        }
        return new ArrayList<>();
    }

    public static int askUserMoney() {
        System.out.println("투입 금액을 입력해주세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            askUserMoney();
        }
        return 0;
    }

    public static String askItemBuy() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            askItemBuy();
        }
        return BLANK;
    }
}
