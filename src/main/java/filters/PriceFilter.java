package filters;

import flower.store.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.security.KeyStore;

@Getter @Setter
public class PriceFilter implements SearchFilter {
    private double minPrice = -1;
    private double maxPrice = -1;

    public PriceFilter(double minPrice, boolean is_it_max) {
        if(is_it_max){
            this.maxPrice = minPrice > 0 ? minPrice : 0;
        }
        else {
            this.minPrice = minPrice > 0 ? minPrice :0;
        }
    }

    public  PriceFilter(double minPrice , double maxPrice){
        this.maxPrice = minPrice > 0 ? minPrice : 0;
        this.minPrice = minPrice > 0 ? minPrice :0;
    }


    public boolean match(Item item) {
        if (this.maxPrice != -1 && this.minPrice != -1) {
            if (this.maxPrice > item.getPrice() && item.getPrice() > this.minPrice) {
                return true;
            }
        }else if(this.maxPrice != -1 && item.getPrice() < this.maxPrice){
            return true;
        }else if (this.minPrice != -1 && item.getPrice() > this.minPrice){
            return true;
        }
        return false;
        }
}