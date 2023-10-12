package flower.store;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Flower extends Item {
    @lombok.Getter
    private double sepalLength;
    private FlowerColor color;
    @lombok.Getter
    private double price;
    @lombok.Getter
    private FlowerType flowerType;

    public Flower(Flower flower){
        this.color = flower.color;
        this.price = flower.price;
        this.sepalLength = flower.sepalLength;
        this.flowerType = flower.flowerType;
    }

    public String getColor() {
        return color.toString();
    }

}
