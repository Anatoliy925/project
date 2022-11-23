package lpnu.mapper;

import lpnu.dto.PizzaDTO;
import lpnu.dto.ToppingDTO;
import lpnu.entity.Pizza;
import lpnu.entity.Topping;

public class ToppingMapper {
    public static ToppingDTO toDTO(Topping topping){
        ToppingDTO toppingDTO = new ToppingDTO();

        toppingDTO.setId(topping.getId());
        toppingDTO.setName(topping.getName());
        toppingDTO.setPrice(topping.getPrice());

        return toppingDTO;
    }

    public static Pizza toEntity(PizzaDTO pizzaDTO){
        Pizza pizza = new Pizza();

        pizza.setId(pizzaDTO.getId());
        pizza.setName(pizzaDTO.getName());
        pizza.setPrice(pizzaDTO.getPrice());
        pizza.setAvailable(pizzaDTO.getAvailable());
        pizza.setStatus(pizzaDTO.getStatus());

        return pizza;
    }
}
