package flower.store;

import filters.SearchFilter;

import java.util.ArrayList;
import java.util.List;

public class  Store {
    private final List<Item> items = new ArrayList<>();
    public List<Item>  search(SearchFilter filter) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item:items) {
            if (filter.match(item)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public int getNumberOfItems() {
        return  this.items.size();
    }
}
