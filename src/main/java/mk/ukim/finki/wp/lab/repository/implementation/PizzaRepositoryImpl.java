//package mk.ukim.finki.wp.lab.repository.implementation;
//
//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
//import mk.ukim.finki.wp.lab.model.Pizza;
//import mk.ukim.finki.wp.lab.repository.PizzaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class PizzaRepositoryImpl implements PizzaRepository {
//
//    private final DataHolder dataHolder;
//
//    public PizzaRepositoryImpl(DataHolder dataHolder) {
//        this.dataHolder = dataHolder;
//    }
//
//    @Override
//    public List<Pizza> listOfPizzas() {
//        return this.dataHolder.getPizzas();
//    }
//
//}