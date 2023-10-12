package flower.store;

import lombok.Getter;
import lombok.Setter;

public class FlowerPack extends Item{
    @Getter@Setter
    private Flower flower;
    @Getter
    private int quantity;
    private double price;

    public double getPrice(){
        return quantity * getFlower().getPrice();
    }

    public void setQuantity(int q){
        this.quantity = q < 1?1 : q;
    }

    public  FlowerPack(Flower flower, int quantity){
        this.flower = flower;
        this.quantity = quantity;
    }

}