package lpnu.mapper;


import lpnu.dto.PizzaDTO;
import lpnu.entity.Pizza;

public class PizzaMapper {
    public static PizzaDTO toDTO(Pizza pizza){
        PizzaDTO pizzaDTO = new PizzaDTO();

        pizzaDTO.setId(pizza.getId());
        pizzaDTO.setName(pizza.getName());
        pizzaDTO.setPrice(pizza.getPrice());
        pizzaDTO.setToppings(pizza.getToppings());
        pizzaDTO.setAvailable(pizza.getAvailable());
        pizzaDTO.setStatus(pizza.getStatus());

        return pizzaDTO;
    }

    public static Pizza toEntity(PizzaDTO pizzaDTO){
        Pizza pizza = new Pizza();

        pizza.setId(pizzaDTO.getId());
        pizza.setName(pizzaDTO.getName());
        pizza.setPrice(pizzaDTO.getPrice());
        pizza.setToppings(pizzaDTO.getToppings());
        pizza.setAvailable(pizzaDTO.getAvailable());
        pizza.setStatus(pizzaDTO.getStatus());

        return pizza;
    }
}
