package flower.store;

import filters.PriceFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchTest {

    private static final int rosePrice = 50;
    private static  final int tulipPrice = 50;
    private static final int roseQuantity = 3;
    private static final int newQuantity = 4;
    private static final int maxPrice = 300;
    private static final int minPrice = 60;
    private static final int minPriceForFirst = 50;
    private static final int expectedFromFirst = 3;
    private static final int newLength = 1;

    private Flower rose;

    private Flower tulip;
    private Flower newFlower;
    @BeforeEach
    public void init() {


        rose = new Flower();
        rose.setPrice(rosePrice);
        tulip = new Flower();
        tulip.setPrice(tulipPrice);
        newFlower = new Flower(rose);
    }

    @Test
    public void testFilterPrice() {


        FlowerPack pack = new FlowerPack(rose, roseQuantity);
        Store store = new Store();
        FlowerBucket bucket = new FlowerBucket();
        pack.setQuantity(newQuantity);
        bucket.addPack(pack);
        store.addItem(bucket);
        store.addItem(tulip);
        store.addItem(newFlower);
        Assertions.assertEquals(expectedFromFirst, store.getNumberOfItems());
        List<Item> searchResult = store.search(new PriceFilter(minPriceForFirst, false));
        Assertions.assertEquals(newLength, searchResult.size());
        Assertions.assertEquals(bucket, searchResult.get(0));
        Store newStore = new Store();
        newStore.addItem(bucket);
        newStore.addItem(rose);
        newStore.addItem(tulip);
        searchResult = store.search(new PriceFilter(minPrice, maxPrice));
        Assertions.assertEquals(newLength, searchResult.size());
        Assertions.assertEquals(bucket, searchResult.get(0));
    }
}
