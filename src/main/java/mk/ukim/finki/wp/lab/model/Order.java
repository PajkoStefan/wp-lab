package mk.ukim.finki.wp.lab.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
@Data
public class Order {

    private String pizzaType;
    private String pizzaSize;
    private String clientName;
    private String clientAddress;
    private Long orderId;


    public Order(String pizzaType, String pizzaSize, String clientName, String clientAddress) {
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId  = Math.abs(new Random().nextLong());
    }
}
