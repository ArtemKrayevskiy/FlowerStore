package flower.store;

import lombok.*;


@Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Flower extends Item{
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
    private double price;
    @Getter
    private FlowerType flowerType;

    public String getColor() {
        return color.toString();
    }

    public Flower(Flower flower){
        this.color = flower.color;
        this.price = flower.price;
        this.sepalLength = flower.sepalLength;
        this.flowerType = flower.flowerType;
    }
}
