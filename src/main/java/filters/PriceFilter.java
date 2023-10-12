package filters;

import flower.store.Item;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PriceFilter implements SearchFilter {
    private double minPrice = -1;
    private double maxPrice = -1;

    public PriceFilter(double minPrice, boolean isItMax) {
        if (isItMax) {
            if (minPrice > 0) {
                this.maxPrice = minPrice;
            } else {
                this.maxPrice =  0;
            }
        }
        else {
            if (minPrice > 0) {
                this.minPrice = minPrice;
            } else {
                this.minPrice =  0;
            }
        }
    }

    public  PriceFilter(double minprice, double maxprice) {
        if (maxprice > 0) {
            this.maxPrice = maxprice;
        }
        else {
            this.maxPrice = 0;
        }
        if (minprice > 0) {
            this.minPrice = minprice;
        } else {
            this.minPrice = 0;
        }
    }


    public boolean match(Item item) {
        if (this.maxPrice != -1 && this.minPrice != -1) {
            return this.maxPrice > item.getPrice() && item.getPrice() > this.minPrice;
        } else if (this.maxPrice != -1 && item.getPrice() < this.maxPrice) {
            return true;
        } else {return this.minPrice != -1 && item.getPrice() > this.minPrice; }
    }
}