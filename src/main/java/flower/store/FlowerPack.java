package flower.store;

import lombok.Getter;
import lombok.Setter;

@Getter
public class FlowerPack extends Item {
    @Setter
    private Flower flower;
    private int quantity;
    public  FlowerPack(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
    }

    public double getPrice() {
        return quantity * getFlower().getPrice();
    }

    public void setQuantity(int q) {
        this.quantity = Math.max(q, 1);
    }


}