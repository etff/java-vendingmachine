package vendingmachine.utils;

import vendingmachine.domain.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemGenerator {
    private static final int NAME = 0;
    private static final int STOCK = 1;
    private static final int PRICE = 2;
    public static final String SEMICOLON = ";";
    public static final String COMMA = ",";

    private ItemGenerator() {
    }

    public static List<Item> generateItem(String textItems) {
        List<Item> items = new ArrayList<>();
        String[] itemSplit = textItems.split(SEMICOLON);
        for (String item : itemSplit) {
            String removeBracket = removeBracket(item);
            String[] details = removeBracket.split(COMMA);
            String name = details[NAME];
            int stock = parseNumber(details[STOCK]);
            int price = parseNumber(details[PRICE]);
            items.add(new Item(name, stock, price));
        }
        return Collections.unmodifiableList(items);
    }

    private static String removeBracket(String text) {
        String textReplaced = text;
        textReplaced = textReplaced.replace("[", "");
        textReplaced = textReplaced.replace("]", "");
        return textReplaced;
    }

    private static int parseNumber(String textNumber) {
        try {
            return Integer.parseInt(textNumber);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage() + "잘못된 입력입니다.");
        }
        return 0;
    }
}
