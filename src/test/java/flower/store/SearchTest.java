package flower.store;

import filters.PriceFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static flower.store.FlowerColor.RED;
import static flower.store.FlowerType.ROSE;
import static flower.store.FlowerType.TULIP;
import static flower.store.FlowerColor.BLUE;
public class SearchTest {

    private Flower rose;
    private Flower tulip;
    private Flower new_flower;
    @BeforeEach
    public void init() {

        rose = new Flower(50, RED, 49, ROSE);
        tulip = new Flower(50, BLUE, 25, TULIP);
        new_flower = new Flower(rose);
    }

    @Test
    public void testFilterPrice() {
        FlowerPack pack = new FlowerPack(rose , 3);
        Store store = new Store();
        FlowerBucket bucket= new FlowerBucket();
        pack.setQuantity(4);
        bucket.add_pack(pack);
        store.add_item(bucket);
        store.add_item(tulip);
        store.add_item(new_flower);
        Assertions.assertEquals(3, store.get_number_of_items());
        List<Item> search_result = store.search(new PriceFilter(50, false));
        Assertions.assertEquals(1, search_result.size());
        Assertions.assertEquals(bucket, search_result.get(0));
        Store new_store = new Store();
        new_store.add_item(bucket);
        new_store.add_item(rose);
        new_store.add_item(tulip);
        search_result = store.search(new PriceFilter(60, 300));
        Assertions.assertEquals(1, search_result.size());
        Assertions.assertEquals(bucket, search_result.get(0));
    }
}
