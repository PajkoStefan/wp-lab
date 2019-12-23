package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Order {

    private String pizzaType;
    private String pizzaSize;
    private String clientName;
    private String clientAddress;
    private Long orderId;

    public Order(String pizzaType, String pizzaSize, String clientName, String clientAddress, Long orderId){
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId = orderId;
    }

}
