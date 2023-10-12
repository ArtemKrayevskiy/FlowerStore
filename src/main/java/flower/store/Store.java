package flower.store;

import filters.SearchFilter;

import java.util.ArrayList;
import java.util.List;

public class  Store {
    private final List<Item> items = new ArrayList<>();
    public List<Item>  search(SearchFilter filter){
        List<Item> found_items = new ArrayList<>();
        for (Item item:items) {
            if (filter.match(item)){
                found_items.add(item);
            }
        }
        return found_items;
    }

    public void add_item(Item item){
        this.items.add(item);
    }

    public int get_number_of_items(){
        return  this.items.size();
    }
}
