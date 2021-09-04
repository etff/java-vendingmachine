package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemRepository {
    private Map<Name, Item> items = new HashMap<>();

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public Optional<Item> getItem(Name name) {
        return Optional.ofNullable(items.get(name));
    }

    public Optional<Item> subtractItem(Name name) {
        Item item = items.get(name);
        if (Objects.nonNull(item)) {
            return Optional.of(item.purchase());
        }
        return Optional.empty();
    }

    public List<Item> getItems() {
        return items.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
