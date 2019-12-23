package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Pizza {

    private String name;
    private String description;

    public Pizza(String name, String description){
        this.name = name;
        this.description = description;
    }
}
