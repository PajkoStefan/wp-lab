package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.UUID;


@Data
public class Order {

    private String pizzaType;
    private String pizzaSize;
    private String clientName;
    private String clientAddress;
    private UUID orderId;


    public Order(){
        this.orderId = UUID.randomUUID();
    }

    public Order(String pizzaType, String pizzaSize, String clientName, String clientAddress) {
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId  = UUID.randomUUID();
    }
}
